package com.likai.chapter11.practice;

import java.util.*;

/**
 * Created by likai on 2018/10/21.
 */
public class Test2 {
    public static void main(String [] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)) ;
        Integer [] moreInts = {6,7,8,9,10} ;
        collection.addAll(Arrays.asList(moreInts)) ;

        Collections.addAll(collection,11,12,13,14,15) ;

        Collections.addAll(collection,moreInts) ;

        List<Integer> list = Arrays.asList(16,17,18,19,20) ;

        //把索引为1的元素替换为99
        list.set(1,99) ;

        for (Integer i : collection) {
            System.out.println(i);
        }
        System.out.println("-------------------------------");
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}
