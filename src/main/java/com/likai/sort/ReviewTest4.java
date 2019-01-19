package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/09.
 * 希尔排序 复习
 */
public class ReviewTest4 {
    public static void main(String [] args) {
        int [] array = Range.rangeArr(15) ;
        System.out.println(Arrays.toString(array));
        /**
         * 第二个条件 h 要 大于 0
         */
        for(int h = array.length / 2; h > 0; h /= 2) {
            for(int i = h,len = array.length ; i < len  ; i ++) {

                int x = array[i] ;
                int k = i - h ;
                while (k >= 0 && array[k] > x) {
                    array[k + h] = array[k] ;
                    k -= h ;
                }
                array[k + h] = x ;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
