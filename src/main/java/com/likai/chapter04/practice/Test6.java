package com.likai.chapter04.practice;

/**
 * Created by likai on 2018/08/05.
 */
public class Test6 {
    public static void main(String [] args) {
        for (int i : fibonacci(9)) {
            System.out.println(i);
        }
    }

    public static int [] fibonacci(int length) {
        int [] array = new int[length] ;
        for(int i = 0 ; i < length; i ++) {
            if(i == 0 || i == 1) {
                array[i] = 1 ;
            } else {
                array[i] = array[i - 1] + array[i - 2] ;
            }
        }

        return array ;
    }
}
