package com.likai.chapter21.pratice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Fibonacci3 implements Callable<Integer> {
    private int n ;
    ExecutorService exec = Executors.newCachedThreadPool() ;
    public Fibonacci3() {
        super();
    }
    public Fibonacci3(int n) {
        this.n = n ;
    }

    public int f(int n) {
        if(n == 1) {
            return 1 ;
        } else if(n == 2) {
            return 2 ;
        } else {
            return f(n -2) + f(n -1) ;
        }
    }

    public Future<Integer> runTask(int n) {
        this.n = n ;
        return this.exec.submit(this) ;
    }


    @Override
    public Integer call() throws Exception {
        int result = 0 ;
        for(int i = 1; i <= this.n; i ++) {
            result += f(i) ;
        }
        return result;
    }
}
public class Test10 {

    public static void main(String [] args) {
        Fibonacci3 f = null ;
        try {
            f = new Fibonacci3() ;
            for(int i = 0 ; i < 15; i ++) {
                System.out.println(f.runTask(i + 10).get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            f.exec.shutdown();
        }

    }
}
