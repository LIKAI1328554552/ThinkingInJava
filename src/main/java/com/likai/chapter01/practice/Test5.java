package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/02.
 */
public class Test5 {
    public static void main(String [] args) {
        /**
         * 自动装箱
         */
        Byte a = 1 ;
        Character b = 'a' ;
        Short c = 1 ;
        Integer d = 1 ;
        float s = 1 ;
        Float e = s ;
        Long f = 1l ;
        Double g = 1d ;
        Boolean h = true ;

        /**
         * 自动拆箱
         */

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}
