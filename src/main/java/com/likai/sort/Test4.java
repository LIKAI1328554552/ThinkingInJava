package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2019/01/08.
 */
public class Test4 {
    public static void main(String [] args) {
        /*int [] array = Range.rangeArr(8) ;*/
        int [] array = {100,90,80,70,60,50,40,30} ;

        System.out.println(Arrays.toString(array));
        //h为数组长度/2 每次循环/2 最后h为1 1/2 取整为0
        for(int h = array.length / 2 ; h > 0 ; h /= 2) {
            System.out.println(h);
            //从h之后依次往后移动
            for(int i = h,len = array.length ; i < len ; i ++) {
                //记录当前值
                int temp = array[i] ;
                //向前移动h位置
                int k = i - h ;
                while(k >= 0 && array[k] > temp) {
                    array[k + h] = array[k] ;
                    k -= h ;
                }
                array[k + h] = temp ;

            }
        }

        System.out.println(Arrays.toString(array));
    }
}
