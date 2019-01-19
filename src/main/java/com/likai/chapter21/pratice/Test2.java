package com.likai.chapter21.pratice;

class Fibonacci implements Runnable {

    private int n ;
    public Fibonacci() {
        super();
    }

    public Fibonacci(int n) {
        this.n = n ;
    }

    public int f(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2 ;
        } else {
            return f(n -2) + f(n - 1) ;
        }
    }

    @Override
    public void run() {
        for(int i = 1 ; i <= this.n; i ++) {
            int num = f(i) ;
            System.out.print(num + " ");
            System.out.println();
        }

    }
}
public class Test2 {
    public static void main(String [] args) {

        for(int i = 0 ; i < 100; i ++) {
            new Thread(new Fibonacci(15)).start();
        }
    }
}
