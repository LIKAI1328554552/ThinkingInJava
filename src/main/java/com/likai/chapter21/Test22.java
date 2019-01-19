package com.likai.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A_22 implements Runnable {
    boolean flag = false ;
    @Override
    public synchronized void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("sleep interrupted in A22");
        }

        System.out.println("A setting flag = true");
        flag = true ;
    }
}

class BusyWait implements Runnable {
    A_22 a = new A_22() ;
    long start,end;
    public  synchronized A_22 getA() {
        return a ;
    }
    private BusyWait(A_22 a) {
        this.a = a ;
    }

    public static BusyWait bulidBusyWait(A_22 a) {
        return new BusyWait(a) ;
    }
    @Override
    public synchronized void run() {
        System.out.println("Busy a.flag = " + a.flag);
        while (!Thread.interrupted()) {
            start = System.nanoTime() ;
            if (a.flag) {
                a.flag = false ;
                System.out.println("BusyWait reset a.flag = false");
                end = System.nanoTime() ;
                System.out.println("Busy waiting " + (end - start) + " nanoseconds");
            }
        }
    }
}

class BetterWait implements Runnable {
    private A_22 a = new A_22() ;
    public synchronized A_22 getA() {
        return this.a ;
    }
    private BetterWait(A_22 a) {
        this.a = a ;
    }

    public static BetterWait bulidBetterWait(A_22 a) {
        return new BetterWait(a) ;
    }
    @Override
    public synchronized void run() {
        System.out.println("BetterWait a.flag =" + this.a.flag);
        try {
            while (!a.flag) {
                wait();
                a.flag = false ;
                System.out.println("BetterWait reset a.flag = false");
            }
        } catch (Exception e) {
            System.out.println("BetterWait.run() interrupted");
        }
    }
}
public class Test22 {
    public static void main(String [] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        BusyWait busyWait = BusyWait.bulidBusyWait(new A_22()) ;
        exec.execute(busyWait.a);
        exec.execute(busyWait);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in main()");
        }
        System.out.println();

        BetterWait betterWait = BetterWait.bulidBetterWait(new A_22()) ;
        exec.execute(betterWait.getA());
        exec.execute(betterWait);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in main()");
        }
        synchronized(betterWait) {
            System.out.println("Sending better.notifyAll()");
            betterWait.notifyAll();
        }
        exec.shutdownNow() ;
    }
}
