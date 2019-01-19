package com.likai.chapter21.pratice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SyncTest11 { // all methods use same lock
    private Lock lock = new ReentrantLock();
    public void f1() {
        lock.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("f1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void g1() {
        lock.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("g1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void h1() {
        lock.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("h1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}

class SyncTest21 { // each method has a different lock
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();

    public void f2() {
        lock1.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("f2()");
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }
    public void g2() {
        lock2.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("g2()");
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }
    public void h2() {
        lock3.lock();
        try {
            for(int i = 0; i < 500; i++) {
                System.out.print("h2()");
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}

public class Ex16 {
    public static void main(String[] args) {
        final SyncTest11 st1 = new SyncTest11();
        final SyncTest21 st2 = new SyncTest21();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
    }
}