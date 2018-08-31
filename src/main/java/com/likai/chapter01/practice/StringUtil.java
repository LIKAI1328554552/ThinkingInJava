package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/02.
 */
public class StringUtil {

    public static int storage(String s) {
        return s.length() * 2 ;
    }

    public static void main(String [] args) {
        String name = "likai" ;
        System.out.println(StringUtil.storage(name));
    }
}
