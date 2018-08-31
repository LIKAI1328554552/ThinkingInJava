package com.likai.chapter04.practice;

import java.util.Random;

/**
 * Created by likai on 2018/08/04.
 */
public class Test2 {
    static int [] array = new int[25] ;
    public static void main(String [] args) {
        Random random = new Random() ;
        for(int i = 0 ; i < array.length; i ++) {
            array[i] = random.nextInt(100) ;
        }

        System.out.println(toCompare(array));
    }

    public static String toCompare(int [] arr) {
        StringBuffer greater = new StringBuffer("大于紧随它而生成的值:") ;
        StringBuffer less = new StringBuffer("小于紧随它而生成的值:") ;
        StringBuffer equal = new StringBuffer("等于于紧随它而生成的值:") ;
        String space = "  " ;
        for(int i = 0 ; i < arr.length; i ++) {
            if (i != arr.length -1) {
                if(arr[i] > arr[i + 1]) {
                    greater.append(arr[i]) ;
                    greater.append(space) ;
                }
                if(arr[i] < arr[i + 1]) {
                    less.append(arr[i]) ;
                    less.append(space) ;
                }
                if(arr[i] == arr[i + 1]) {
                    equal.append(arr[i]) ;
                    equal.append(space) ;
                }
            }
        }

        return greater.toString() + space + less.toString() + space + equal.toString() ;
    }
}
