package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/10/28.
 */
public class Test2 {
    public static void main(String [] args) {
        char [] chars = {'a','b','c','d','e','f'} ;
        if (chars instanceof Object) {
            System.out.println("char 数组 是一个对象");
        } else {
            System.out.println("char 数组 不是一个对象");
        }
    }
}
