package com.likai.chapter04.practice;

/**
 * Created by likai on 2018/08/04.
 */
public class Test4 {
    public static void main(String [] args) {
        for(int i = 1; i < 1000; i++ ) {
            int factors = 0;
            for(int j = 1; j < (i + 2)/2; j++ ) {
                if((i % j) == 0) factors++;
            }
            if(factors < 2) System.out.println(i + " is prime");
        }
    }

    /*public static void main(String [] args) {
        for(int i = 1 ; i < 1000; i ++) {
            boolean flag = false ;
            for (int n = 2 ; n < i; n ++) {
                if (i % n == 0) {
                    //其中有能被整除的数
                    flag = false ;
                    break;
                } else {
                    flag = true ;
                }
            }
            if(flag) {
                System.out.println(i);
            }
        }
    }*/
}
