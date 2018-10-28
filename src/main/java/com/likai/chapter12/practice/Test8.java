package com.likai.chapter12.practice;

import com.likai.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/28.
 */
public class Test8 {
    public static void main(String [] args) {
        String content = TextFile.read("TextFile.java") ;
        Pattern pattern = Pattern.compile("[A-Z]") ;
        Matcher m = pattern.matcher(content) ;
    }
}
