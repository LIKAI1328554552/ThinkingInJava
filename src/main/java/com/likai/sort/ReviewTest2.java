package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/04.
 * 选择排序 复习
 */
public class ReviewTest2 {
    public static void main(String [] args) {
        int [] array = Range.rangeArr(15) ;
        System.out.println(Arrays.toString(array));

        for(int i = 0,len = array.length - 1 ; i < len; i ++) {
            for (int j = i + 1,len2 = array.length; j < len2; j ++) {
                if (array[i] > array[j]) {
                    int temp = array[i] ;
                    array[i] = array[j] ;
                    array[j] = temp ;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
