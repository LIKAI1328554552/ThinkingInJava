package com.likai.chapter11.practice;

import java.util.*;

/**
 * Created by likai on 2018/10/21.
 */
public class Test5 {
    public static void main(String [] args) {
        String [] strs = {"1","2"} ;
        List<String> arrayList = new ArrayList<String>() ;
        List<String> linkedList = new LinkedList<String>() ;
        Collections.addAll(arrayList,strs) ;
        Collections.addAll(linkedList,strs) ;
        arrayList.add("3") ;
        linkedList.add("3") ;
        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}

