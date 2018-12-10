package com.likai.chapter17.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test5 {
    public static void main(String [] args) {
        Map<String,String> map = new HashMap<String,String>() ;

        map.put("1","1") ;
        map.put("2","2") ;
        map.put("3","3") ;
        map.put("4","4") ;
        map.put("5","5") ;
        map.put("6","6") ;
        map.put("7","7") ;
        map.put("8","8") ;
        map.put("9","9") ;

        Set entries = map.entrySet( );
        if(entries != null) {
            Iterator iterator = entries.iterator( );
            while(iterator.hasNext( )) {
                Map.Entry<String,String> entry = (Map.Entry) iterator.next();
                String key = entry.getKey( );
                String value = entry.getValue();

                System.out.println(key);
                System.out.println(value);
            }
        }

        System.out.println(map);
    }
}
