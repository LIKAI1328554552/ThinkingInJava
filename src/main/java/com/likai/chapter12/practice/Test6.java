package com.likai.chapter12.practice;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/27.
 */
public class Test6 {
    public static void main(String [] args) {
        if(args.length < 2) {
            System.out.println("异常");
            System.exit(0);
        }
        Pattern pattern = Pattern.compile(args[1]) ;
        File [] files = new File("D:" + File.separator + args[0]).listFiles() ;
        if(files.length != 0 || files != null) {
            for (File file : files) {
                String fileName = file.getName() ;
                Matcher matcher = pattern.matcher(fileName) ;
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } else {

        }
    }
}
