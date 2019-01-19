package com.likai.chapter21.pratice;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TimeTask implements Runnable {
    private Random random = new Random() ;
    @Override
    public void run() {
        try {
            int t = 1000 * this.random.nextInt(10) ;
            TimeUnit.MICROSECONDS.sleep(t);
            System.out.println("睡眠 " + t/1000 + " 秒");
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test6 {
    public static void main(String [] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 10; i ++) {
            exec.execute(new TimeTask());
        }
    }
}
