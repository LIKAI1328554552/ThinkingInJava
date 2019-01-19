package com.likai.chapter21.pratice;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SimplePriorities implements Runnable {
    private int countDown = 5 ;
    private volatile double d ;
    private int priority ;
    public SimplePriorities(int priority) {
        this.priority = priority ;
    }

    public String toString() {
        return Thread.currentThread() + " : " + this.countDown ;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while(true) {
            for(int i = 1 ; i < 100000; i ++) {
                d += (Math.PI + Math.E) / (double) i ;
                if(i % 1000 == 0) {
                    Thread.yield() ;
                }
            }
            System.out.println(this);
            if(-- this.countDown == 0) {
                return ;
            }
        }
    }
}

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        //异常不能跨线程传播回main() 因此要在run()中抛出异常 而不是向上抛
        try {
            while (countDown -- > 0) {
                System.out.println(status());
                //过去的写法
               /* Thread.sleep(100);*/
                //1.6之后的写法
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        for(int i = 0 ; i < 10; i ++) {
            Thread thread = new Thread(new SleepingTask());
            thread.start();
        }
    }

    @Test
    public void test2() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 5; i ++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();

    }
}
