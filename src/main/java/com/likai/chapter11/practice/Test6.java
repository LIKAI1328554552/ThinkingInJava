package com.likai.chapter11.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by likai on 2018/10/21.
 */
public class Test6 {
    public static void main(String [] args) {
        Map<String,Gerbil> map = new HashMap<String,Gerbil>() ;
        map.put("jack",new Gerbil(1)) ;
        map.put("peter",new Gerbil(2)) ;
        map.put("jerry",new Gerbil(3)) ;
        map.put("tom",new Gerbil(4)) ;
        map.put("harryPotter",new Gerbil(5)) ;

        Iterator<String> iter = map.keySet().iterator() ;
        while(iter.hasNext()) {
            String name = iter.next() ;
            System.out.println("名字: " + name );
            map.get(name).hop() ;
        }
    }
}
