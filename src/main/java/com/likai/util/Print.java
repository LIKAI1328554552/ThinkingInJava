package com.likai.util;

import java.io.PrintStream;

/**
 * Created by likai on 2018/08/07.
 */
public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print() {
        System.out.println();
    }

    public static void printb(Object obj) {
        System.out.print(obj);
    }

    public static PrintStream printf(String format,Object... args) {
        return System.out.printf(format,args) ;
    }
}
