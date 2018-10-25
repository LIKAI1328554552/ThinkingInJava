package com.likai.chapter12.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/24.
 */
public class Test2 {
    public static void main(String [] args) {
        String [] regex = {"^Java","\\Berg.*","n.w\\s+h(a|i)s","s?", "s+", "s{4}", "s{1}.", "s{0,3}"} ;
        String content = "Java now has regular expressions" ;
        for (String s : regex) {
            Pattern p = Pattern.compile(s) ;
            Matcher m = p.matcher(content) ;
            if(!m.find()) {
                System.out.println("正则:" + s + " 与字符串:" + content + "  无匹配");
            } else {
                System.out.println("正则:" + s + " 成功");
            }
        }
    }
}
