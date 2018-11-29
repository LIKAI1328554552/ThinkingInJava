package com.likai.util;

import java.util.Random;

/**
 * Created by likai on 2018/08/07.
 */
public class Range {
    public static int [] range(int length) {
        int [] args = new int[length] ;
        for(int i = 0 ; i < length; i ++) {
            args[i] = i ;
        }

        return args ;
    }

    public static int [] range(int start,int end) {
        int length = end - start ;
        int [] args = new int [length] ;
        for(int i = 0 ; i < length; i ++) {
            args[i] = start + i ;
        }

        return args ;
    }

    public static int [] range(int start, int end, int step) {
        int length = (end - start) / step ;
        int [] args = new int[length] ;
        for(int i = 0 ; i < length; i ++) {
            args[i] = start + (i * step) ;
        }

        return args ;
    }


    public static int [] rangeArr(int length) {
        Random random = new Random(47) ;
        int [] arr = new int[length] ;

        for(int i = 0 ; i < length ; i ++) {
            arr[i] = random.nextInt(5000) ;
        }

        return arr ;
    }
}
