package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/04.
 */
public class Test3 {
    public static void main(String [] args) {
        int [] array = Range.rangeArr(10) ;

        System.out.println(Arrays.toString(array));

        //外层循环从1位置开始
        for(int i = 1,len = array.length ; i < len; i ++) {
            //如果当前位置的值 大于 前一个位置的值
            if(array[i - 1] > array[i]) {
                //当前位置的值
                int x = array[i] ;
                //k 表示前一个位置
                int k = i -1 ;
                //如果前一个位置的值大于当前位置的值
                while(k >= 0 && array[k] > x) {
                    //将前一个位置的值 赋给 当前位置的值
                    array[k + 1] = array[k] ;
                    //k依次向前移动
                    k -= 1 ;
                }
                //k表示前一位(第一位时k=-1) k+1 表示不满足条件(k>=0(表示第一位) 或者 前一位的值小于i位置的值) 那个值的前一个
                array[k + 1] = x ;
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
