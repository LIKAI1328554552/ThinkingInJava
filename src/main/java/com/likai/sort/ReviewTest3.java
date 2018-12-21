package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/09.
 * 插入排序 复习
 */
public class ReviewTest3 {
    public static void main(String [] args) {
        int [] array = Range.rangeArr(15) ;

        System.out.println(Arrays.toString(array));

        for(int i = 1,len = array.length ; i < len; i ++) {

            if(array[i - 1] > array[i]) {
                int x = array[i] ;
                int k = i -1 ;
                while(k >= 0 && array[k] > x) {
                    array[k + 1] = array[k] ;
                    k -= 1 ;
                }

                array[k + 1] = x ;
            }

        }


        System.out.println(Arrays.toString(array));

    }
}
