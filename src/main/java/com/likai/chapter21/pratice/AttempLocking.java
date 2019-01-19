package com.likai.chapter21.pratice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttempLocking {
    private ReentrantLock lock = new ReentrantLock() ;
    public void untimed() {
        //尝试加锁
        boolean captured = lock.tryLock() ;
        try {
            System.out.println("tryLock() " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }


    public void timed() {
        boolean captured = false ;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS) " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String [] args) {
        final AttempLocking locking = new AttempLocking() ;
        locking.untimed();
        locking.timed();

        new Thread() {
            {setDaemon(true) ;}
            public void run() {
                locking.lock.lock();
                System.out.println("acquired");
            }

        }.start();

        Thread.yield();

        locking.untimed();
        locking.timed();

    }
}
