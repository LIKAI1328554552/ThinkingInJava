package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/11/04.
 */


public class Test3 {
    public static void main(String [] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class ;
        FancyToy fancyToy = ftClass.newInstance() ;
        Class<? super FancyToy> up = ftClass.getSuperclass() ;

//        Class<Toy> up2 = ftClass.getSuperclass() ;
        Object obj = up.newInstance() ;
//        Toy toy = up.newInstance() ;

    }
}
