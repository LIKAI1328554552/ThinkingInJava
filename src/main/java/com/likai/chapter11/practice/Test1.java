package com.likai.chapter11.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by likai on 2018/10/21.
 */
public class Test1 {
    public static void main(String [] args) {
        Set<String> set = new HashSet<String>() ;
        set.add("likai") ;
        set.add("likai") ;
        set.add("lixinyi") ;
        System.out.println(set.size());
        for (String s : set) {
            System.out.println(s);
        }
    }
}
