package com.likai.chapter18.pratice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
    private String [] list ;
    public Test4() {
        super();
    }

    public Test4(String filePath) {
        list = new File(filePath).list() ;
    }

    public String [] list() {
        return this.list ;
    }

    public String [] list(String regex) {
        Pattern pattern = Pattern.compile(regex) ;
        List<String> newList = new ArrayList<String>() ;

        for (String s : this.list) {
            if(pattern.matcher(s).matches()) {
                newList.add(s) ;
            } else {
                continue;
            }
        }
        return newList.toArray(new String [0]) ;
    }

    public static void main(String [] args) throws IOException {
        Test4 test4 = new Test4(new File("").getCanonicalPath()) ;
        String [] list = null ;
        list = test4.list() ;
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------------");

        list = test4.list(".+\\.xml") ;
        for (String s : list) {
            System.out.println(s);
            System.out.println(s.length());
        }

    }
}
