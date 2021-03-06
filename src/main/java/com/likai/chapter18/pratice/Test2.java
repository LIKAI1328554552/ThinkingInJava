package com.likai.chapter18.pratice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Test2 {
    //参数使用final申明 可以提供给内部类
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex) ;

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        } ;
    }

    public static void main(String [] args) {
        File path = new File(".") ;
        String [] list = null ;
        if(args.length == 0) {
            list = path.list() ;
        } else {
            list = path.list(filter(args[0])) ;
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
