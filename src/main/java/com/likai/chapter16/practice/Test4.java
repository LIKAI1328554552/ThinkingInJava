package com.likai.chapter16.practice;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/11.
 */
public class Test4 {
    public static void main(String [] args) {
        int [] i = new int[7] ;
        int [] j = new int[20] ;
        Arrays.fill(i,49);
        Arrays.fill(j,400);
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));

        System.arraycopy(i,0,j,1,i.length);
        System.out.println(Arrays.toString(j));
    }
}
