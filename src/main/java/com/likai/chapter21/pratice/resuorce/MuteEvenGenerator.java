package com.likai.chapter21.pratice.resuorce;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示加锁注意点
 *  return内容必须在try代码块中出现以确保unlock不会过早的发生
 *  优点 如果任务执行中可能出现异常 我们可以在finally代码块中进行清理  而synchronized的方式不可以
 */
public class MuteEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0 ;
    private Lock lock = new ReentrantLock() ;
    @Override
    public int next() {
        lock.lock();
        try {
            ++ currentEvenValue ;
            //此处并不是原子性操作 可能会出现执行在此处线程被挂起
            Thread.yield();
            ++ currentEvenValue ;

            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String [] args) {
        EvenChecker.test(new MuteEvenGenerator());
    }
}
