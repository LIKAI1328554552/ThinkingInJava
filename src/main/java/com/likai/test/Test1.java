package com.likai.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void test1() {
        List<Map<String,String>> list1 = new ArrayList<Map<String, String>>() ;
        for(int i = 0 ; i < 5; i ++) {
            Map<String,String> map = new HashMap<String, String>() ;

            map.put("name" + i,Integer.toString(i)) ;
            map.put("cece","cece") ;
            list1.add(map) ;

        }

        List<Map<String,String>> list2 = new ArrayList<Map<String, String>>() ;
        for(int i = 0 ; i < 5; i ++) {
            Map<String,String> map = new HashMap<String, String>() ;

            map.put("name" + i,Integer.toString(i)) ;
            map.put("shishi","shishis") ;
            list2.add(map) ;

        }


        System.out.println(list1);
        System.out.println(list2);

        list1.removeAll(list2) ;

        System.out.println(list1);
    }

    @Test
    public void test2() {
        List<Test2> list1 = new ArrayList<Test2>() ;
        for(int i = 0 ; i < 5; i ++) {
            Test2 test2 = new Test2("csname" + i,Integer.toString(i),"1") ;
            list1.add(test2) ;
        }

        List<Test2> list2 = new ArrayList<Test2>() ;
        for(int i = 0 ; i < 5; i ++) {
            Test2 test2 = new Test2("name" + i,Integer.toString(i+10),"2") ;
            list2.add(test2) ;

        }


        System.out.println(list1);
        System.out.println(list2);

        list1.removeAll(list2) ;

        System.out.println(list1);
    }


}
