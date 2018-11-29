package com.likai.sort;

import java.util.Arrays;

/**
 * Created by likai on 2018/10/28.
 */
public class Test2 {
    public static void main(String [] args) {
        int [] arrays = {22,4364,121,55,8973424,12312,3,89} ;
        //外层循环依次向下遍历
        for(int i = 0 , len1 = arrays.length - 1 ; i < len1 ; i ++) {
            //内层循环 i:为当前位置 j:为下一个位置 控制长度: i最大为数组长度-1 因此j最大为数组长度
            for(int j = i + 1,len2 = arrays.length ; j < len2 ; j++) {

                if(arrays[i] > arrays[j]) {
                    int x = arrays[i] ;
                    arrays[i] = arrays[j] ;
                    arrays[j] = x ;
                }

            }

        }

        System.out.println(Arrays.toString(arrays));
    }
}
