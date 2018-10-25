package com.likai.chapter11.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by likai on 2018/10/21.
 */
public class Test3 {
    public static void main(String [] args) {
        String str = "1,2,3,4,5,6,7,8" ;

        List<String> list = Arrays.asList(str.split(",")) ;

        /*if(list.contains("3")) {
            System.out.println("222222222222222222");
        }*/

        ListIterator<String> iter = list.listIterator(8) ;
        /*while (iter.hasNext()) {
            String s = iter.next() ;
            System.out.println(s);
        }*/

        while (iter.hasPrevious()) {
            String s = iter.previous() ;
            System.out.println(s);
        }


    }

}
