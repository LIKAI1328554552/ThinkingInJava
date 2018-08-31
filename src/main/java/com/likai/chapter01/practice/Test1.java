package com.likai.chapter01.practice;

import java.util.Random;

/**
 * Created by likai on 2018/08/01.
 * 验证默认初始化
 */
public class Test1 {
    static int a ;
    static char b ;

    public static void toCompare(String str1,String str2) {
        System.out.println(result(str1 == str2)) ;
        System.out.println(result(str1 != str2)) ;
        System.out.println(result(str1.equals(str2))) ;
    }

    public static String result(boolean flag) {
        return flag == true ? "true" : "false" ;
    }

    public static void main(String [] args) {

        short a = (short) 32768 ;

        System.out.println(a);
        System.out.println(b);

        System.out.println(Math.random());

        Random random = new Random() ;
        System.out.println(random.nextInt(2));

        toCompare("aaaa","aaaa") ;
    }
}
