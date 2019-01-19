package com.likai.chapter12.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestNamePattern {

    private static String row = "讯问人：   吴卫东、司珊   记录人：         司珊   " ;
    /*private static String name = "      高峰,王思聪" ;*/

    public static void main(String [] args) {
        //如果其中包含案由
        Pattern pa = Pattern.compile("案\\s*由：") ;
        Matcher ma = pa.matcher(row) ;
        if (ma.find()) {
            String regexA = "(讯问人).*(记录人).*案\\s*由：" ;
            Pattern pattern = Pattern.compile(regexA) ;
            Matcher matcher = pattern.matcher(row) ;
            while (matcher.find()) {
                row = matcher.group() ;
            }
        }

        //使用正则进行拆分
        System.out.println(row);
        String [] array = row.split("[讯问人：|记录人：|案\\s*由]") ;
        System.out.println(Arrays.toString(array));
        for (String name : array) {
            String regex = "[\\u4e00-\\u9fa5]{1}\\s*[\\u4e00-\\u9fa5]{1,3}" ;
            Pattern p = Pattern.compile(regex) ;
            Matcher m = p.matcher(name) ;
            List<String> names = new ArrayList<String>() ;
            while(m.find()) {
                String n = m.group() ;
                //将name中的空格去掉
                n = n.replaceAll(" ","") ;
                names.add(n);
            }
            for (String s : names) {
                System.out.println(s);
            }
            names.clear();
        }



    }
}
