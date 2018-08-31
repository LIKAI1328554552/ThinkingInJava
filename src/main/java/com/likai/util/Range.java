package com.likai.util;

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
}
