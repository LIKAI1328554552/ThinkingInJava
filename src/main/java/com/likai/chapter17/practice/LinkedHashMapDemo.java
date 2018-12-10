package com.likai.chapter17.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String [] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>() ;
        putValues(linkedHashMap);

        System.out.println(linkedHashMap);

        //设置最近最少使用(LRU)策略

        linkedHashMap = new LinkedHashMap<>(16,0.75f,true) ;
        putValues(linkedHashMap);

        System.out.println(linkedHashMap);

        for(int i = 0 ; i < 6; i ++) {
            linkedHashMap.get(i) ;
        }

        System.out.println(linkedHashMap);

        linkedHashMap.get(0) ;

        System.out.println(linkedHashMap);
    }

    public static void putValues(Map map) {

        for(int i = 0 ; i < 10; i ++) {
            map.put(i,Integer.toString(i)) ;
        }

    }
}
