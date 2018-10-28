package com.likai.chapter12.practice;

import com.likai.util.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/28.
 */
public class Test7 {
    public static void main(String [] args) {
        String content = TextFile.read("TextFile.java") ;
        //匹配注释
        /*Pattern pattern = Pattern.compile("((/\\*)(.|[\\r\\n])*?\\*//*|//.*)") ;*/

        //匹配字符串
        Pattern pattern = Pattern.compile("\".*\"") ;
        Matcher matcher = pattern.matcher(content) ;
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
