package com.likai.sort;

/**
 * Created by likai on 2018/10/24.
 */
public class Test1 {
    public static void main(String [] args) {
        int [] array = {100,55,22,7,3,66} ;
        int len = array.length ;
        //从第一个位置依次向下遍历 最大长度为数组长度 - 1
        for(int i = 0; i < len - 1; i ++) {
            //从第一个位置依次向下 最大长度为数组长度 - 1 - i 因为每次一循环都把最大的数 放到了最后一个位置
            for(int j = 0 ; j < len - 1 -i ; j ++) {

                if(array[j] > array [j + 1]) {
                    int x = array [j] ;
                    array [j] = array[j + 1] ;
                    array [j + 1] = x ;
                }

            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }
}
