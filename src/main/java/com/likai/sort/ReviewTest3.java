package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/09.
 * 插入排序 复习
 */
public class ReviewTest3 {
    public static void main(String [] args) {
        int [] arr = Range.rangeArr(10) ;

        System.out.println(Arrays.toString(arr));
        for(int i = 1,len = arr.length ; i < len; i ++) {
            if(arr[i - 1] > arr[i]) {
                int x = arr[i] ;
                int k = i - 1 ;
                while (k >= 0 && arr[k] > x) {
                    arr[k + 1] = arr[k] ;
                    k -- ;
                }
                arr[k + 1] = x ;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
