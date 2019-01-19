package com.likai.chapter21.pratice.resuorce;

/**
 * 使用锁时需要注意的点:
 * 同步代码中使用的域 必须是private防止其他地方可能调用
 */
public class SyncEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0 ;
    @Override
    public synchronized  int next() {
        ++ currentEvenValue ;
        //此处并不是原子性操作 可能会出现执行在此处线程被挂起
        Thread.yield();
        ++ currentEvenValue ;

        return currentEvenValue;
    }

    public static void main(String [] args) {
        EvenChecker.test(new SyncEvenGenerator());
    }
}
