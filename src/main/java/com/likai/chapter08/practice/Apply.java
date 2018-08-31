package com.likai.chapter08.practice;

import java.util.Arrays;

/**
 * Created by likai on 2018/08/17.
 */




public class Apply {

    public static String s = "Hello World!!!!!!!!!!!!!!!!!!!" ;

    public static void process(Processor p,Object o) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(o));
    }

    public static void main(String [] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
