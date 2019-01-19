package com.likai.chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in ;
    public IOBlocked(InputStream in) {
        this.in = in ;
    }
    @Override
    public void run() {
        try {
            System.out.println("Waiting for read(): ");
            in.read() ;
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked IO");
            } else {
                throw new RuntimeException(e) ;
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
class SyncBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SyncBlocked() {
        new Thread() {
            public void run() {
                f() ;
            }
        }.start();
    }
    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f() ;
        System.out.println("Exiting SyncBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool() ;
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r) ;
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true) ;
        System.out.println("Interrupt send to " + r.getClass().getName());
    }

    public static void main(String [] args) throws InterruptedException {
        test(new SleepBlocked()) ;
        test(new IOBlocked(System.in)) ;
        test(new SyncBlocked()) ;
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }
}
