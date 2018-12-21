package com.likai.chapter12.practice;

import com.likai.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/27.
 */
public class Test5 {
    public static void main(String [] args) {

        if(args.length < 2) {
            System.out.println("异常");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]) ;
        int index = 0 ;
        Matcher matcher = p.matcher("") ;
        for (String line : new TextFile(args[0])) {
            matcher.reset(line) ;
            while (matcher.find()) {
                System.out.println(index ++ + ": " + matcher.group() + ": " + matcher.start());
            }
        }

    }
}
