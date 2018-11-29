package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/04.
 * 选择排序 复习
 */
public class ReviewTest2 {
    public static void main(String [] args) {
        int [] arr = Range.rangeArr(15) ;
        System.out.println(Arrays.toString(arr));

        for(int i = 0,len = arr.length - 1 ; i < len; i ++) {
            for(int j = i + 1,len1 = len + 1; j < len1; j ++) {
                if(arr[i] > arr[j]) {
                    int x = arr[i] ;
                    arr[i] = arr[j] ;
                    arr[j] = x ;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
