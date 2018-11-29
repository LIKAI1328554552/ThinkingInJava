package com.likai.chapter16.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by likai on 2018/11/11.
 */
public class Test2 {

    public static Object [] test(int index) {
        BerylliumSphere [] b = new BerylliumSphere[index] ;
        for(int i = 0 ; i < index; i ++) {
            b[i] = new BerylliumSphere() ;
        }

        return b ;

    }
    public static void main(String [] args) {
        List<String> list = new ArrayList<>() ;
        list.add(1,"1") ;
        System.out.println(Arrays.toString(test(20)));
    }
}
