package com.likai.chapter21.pratice.resuorce;

import java.util.concurrent.TimeUnit;

/**
 * 未加锁
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0 ;
    @Override
    public int next() {
        ++ currentEvenValue ;
        //此处并不是原子性操作 可能会出现执行在此处线程被挂起
        ++ currentEvenValue ;

        return currentEvenValue;
    }
    public static void main(String [] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
