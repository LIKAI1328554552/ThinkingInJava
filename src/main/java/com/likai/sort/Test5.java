package com.likai.sort;

import com.likai.util.Range;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Test5 {

    /**
     * 数组进行分区
     * @param arr 数组
     * @param left 左指针位置
     * @param right 右指针位置
     * @param point 关键字
     */
    public static int partition(int [] arr,int left,int right,int point) {
        //左边从-1开始
        int leftPtr = left - 1 ;
        //右边从数组长度
        int rightPtr = right;
        while (true) {
            //1.从左往右找 找到第一个比关键字大的数
            while (leftPtr < rightPtr && arr[++leftPtr] < point) ;
            //2.从右往左找 找到第一个比关键字小的数
            while (leftPtr < rightPtr && arr[--rightPtr] > point) ;

            //3.判断 左指针的位置 小于 右指针的位置
            if(leftPtr < rightPtr) {
                //交换左右指针的值
                int temp = arr[leftPtr] ;
                arr[leftPtr] = arr[rightPtr] ;
                arr[rightPtr] = temp ;
            } else {
                //交换左指针指向的值与关键字的值  用数组的最后一位作为关键字
                int temp = arr[leftPtr] ;
                arr[leftPtr] = arr[right] ;
                arr[right] = temp ;

                return leftPtr ;
            }
        }
    }


    public static void sort(int [] arr,int left,int right) {
        if (left >= right) {
            return;
        }
        //将数组的最后一个值作为关键字
        int point = arr[right] ;
        //对数组进行分区 并且返回分区位置
        int partition = partition(arr,left,right,point);
        //对左边进行排序
        sort(arr,left,partition - 1);
        //对右边进行排序
        sort(arr,partition + 1,right);
    }

    public static void main(String [] args) {
        int [] arr = Range.rangeArr(2000) ;
        System.out.println(Arrays.toString(arr));


        sort(arr,0,arr.length-1);



        System.out.println(Arrays.toString(arr));
    }
}
