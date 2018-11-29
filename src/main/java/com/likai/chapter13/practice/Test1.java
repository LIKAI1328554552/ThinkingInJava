package com.likai.chapter13.practice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by likai on 2018/10/28.
 */
public class Test1 {

    public static void className(Object obj) {
        Class c = obj.getClass() ;
        System.out.println(c.getCanonicalName());
        for (Field field : c.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        if (c.getSuperclass() != null) {
            try {
                className(c.getSuperclass().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String [] args) {
        char [] chars = {'a','b','c','d','e','f'} ;
        className(chars) ;
    }
}
