package com.likai.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A implements Runnable {
    private volatile boolean signal = false ;
    @Override
    public synchronized void run() {
        try {
            while (!signal) {
                System.out.println("A run() wait()");
                wait();
                signal = true ;
                System.out.println("A is done waiting");
            }
        } catch (Exception e) {
            System.out.println("A run interrupted");
        } finally {
            System.out.println("Leaving A run");
        }
    }

    public void message() {
        System.out.println("Hi form A");
    }
}
class B implements Runnable {
    private A a ;
    public A getA() {
        return this.a ;
    }
    B(A a) {
        this.a = a ;
    }
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
            synchronized (a) {
                System.out.println("B run() a.notifyAll");
                a.notifyAll();
            }
        } catch (Exception e) {
            System.out.println("B sleep interrupted");
        }
    }

}
public class Test21 {
    public static void main(String [] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        B b = new B(new A()) ;
        exec.execute(b.getA());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        b.getA().message();
        exec.execute(b);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        exec.shutdownNow() ;
    }
}
