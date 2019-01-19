package com.likai.chapter21.pratice;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CircularSet {
    private int [] array ;
    private int len ;
    private int index = 0 ;
    public CircularSet(int size) {
        this.array = new int[size] ;
        this.len = size ;
        for(int i = 0 ; i < size; i ++) {
            this.array[i] = -1 ;
        }
    }

    public synchronized void add(int i) {
        array[index] = i ;
        index = ++index % len ;
    }

    public synchronized boolean contains(int val) {
        for(int i = 0 ; i < len; i ++) {
            if (array[i] == val) {
                return true ;
            }
        }
        return false ;
    }
    public int [] getArray() {
        return array ;
    }
}
public class SerialNumberChecker {
    private static final int SIZE = 10 ;
    private static CircularSet set = new CircularSet(1000) ;
    private static ExecutorService exec = Executors.newCachedThreadPool() ;
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                //获取当前值的++值 看是否snextSerialNumber 会产生中断
                int serial = SerialNumberGenerator.nextSerialNumber() ;

                if(set.contains(serial)) {
                    System.out.println("Duplicate " + serial);
                    System.exit(0) ;
                }

                set.add(serial);

                System.out.println(Thread.class.getName() + Arrays.toString(set.getArray()));
            }
        }
    }

    public static void main(String [] args) {
        for(int i = 0 ; i < SIZE; i ++) {
            exec.execute(new SerialChecker());

        }   
    }

}
