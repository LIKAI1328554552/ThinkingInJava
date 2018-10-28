package com.likai.chapter12.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/27.
 */
public class Test3 {
    public static void main(String [] args) {
        Pattern pattern = Pattern.compile("\\w+") ;
        Matcher matcher = pattern.matcher("Evening is full of the linnet's wings") ;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }

        System.out.println("-------------------------------");

        int i = 0;
        while (matcher.find(i)) {
            System.out.print(matcher.group() + " ");
            i ++ ;
        }
    }
}
