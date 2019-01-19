package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * create by 2019/01/13 likai
 * 快速排序 复习
 */
public class ReviewTest5 {
    public static void main(String [] args) {
        /**
         * 心法: 左指针将数组分割成一边比目标值小 一边比目标值大
         * 1.左指针从左往右依次查找,如果比目标数大 则停止
         * 2.右指针从右往左依次查找 如果比目标值小 则停止
         * 3. 如果左指针的位置比右指针的位置小 那么交换两个指针所指的值
         *    如果左指针的位置不必右指针的位置小 那么则交换左指针所指的值与目标值
         */
        int [] array = Range.rangeArr(15) ;
        System.out.println(Arrays.toString(array));

        sort(array,0,array.length-1) ;

        System.out.println(Arrays.toString(array));
    }

    public static int position(int [] arr,int left,int right,int target) {
        //左指针从-1开始
        int leftPrt = left - 1 ;
        //右指针从数组结尾开始
        int rightPrt = right ;

        while (true) {
            //执行1
            while (leftPrt < rightPrt && arr[++leftPrt] < target) ;
            //执行2
            while (leftPrt < rightPrt && arr[--rightPrt] > target) ;
            //执行3
            if (leftPrt < rightPrt) {
                int temp = arr[leftPrt] ;
                arr[leftPrt] = arr[rightPrt] ;
                arr[rightPrt] = temp ;
            } else {
                //以数组最后一位作为目标值
                int temp = arr[leftPrt] ;
                arr[leftPrt] = arr[right] ;
                arr[right] = temp ;

                return leftPrt ;
            }
        }
    }


    public static void sort(int [] arr,int left,int right) {

        if (left >= right) {
            return;
        }

        int leftPrt = position(arr,left,right,arr[right]) ;

        sort(arr,left,leftPrt - 1);

        sort(arr,leftPrt + 1,right) ;

    }
}
