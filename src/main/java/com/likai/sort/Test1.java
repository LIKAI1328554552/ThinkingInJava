package com.likai.sort;

/**
 * Created by likai on 2018/10/24.
 */
public class Test1 {
    public static void main(String [] args) {
        int [] array = {100,55,22,7,3,66} ;
        int len = array.length ;
        for(int i = 0; i < len - 1; i ++) {

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
