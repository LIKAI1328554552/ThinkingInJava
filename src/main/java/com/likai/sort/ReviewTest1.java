package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/04.
 * 冒泡排序 复习
 */
public class ReviewTest1 {
   public static void main(String [] args) {
      int [] array = Range.rangeArr(15) ;

       System.out.println(Arrays.toString(array));

       for(int i = 0,len = array.length - 1 ; i < len; i ++) {
           for(int j = 0,len1 = len - i ; j < len1; j ++) {

               if(array[j] > array[j + 1]) {
                   int x = array[j] ;
                   array[j] = array[j + 1] ;
                   array[j + 1] = x ;
               }

           }
       }

       System.out.println(Arrays.toString(array));
   }
}
