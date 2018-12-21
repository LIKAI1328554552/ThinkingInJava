package com.likai.chapter18.pratice;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BufferedInputFile {

    private static List<String> list = new LinkedList<String>() ;

    public static String read(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)) ;

        String s ;
        StringBuffer sb = new StringBuffer() ;
        while((s = reader.readLine()) != null ) {
            sb.append(s) ;
            sb.append("\n") ;
        }

        reader.close();

        return sb.toString() ;

    }

    public static String read2(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)) ;

        String s ;
        StringBuffer sb = new StringBuffer() ;
        while((s = reader.readLine()) != null ) {
            sb.append(s) ;
            sb.append("\n") ;
            list.add(s) ;
        }

        reader.close();

        return sb.toString() ;

    }

    public static String read3(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)) ;

        String s ;
        StringBuffer sb = new StringBuffer() ;
        while((s = reader.readLine()) != null) {
            sb.append(s) ;
            sb.append("\n") ;
            list.add(s.toUpperCase()) ;
        }

        reader.close();
        return sb.toString() ;
    }

    public static String read4(String fileName,String regex) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)) ;
        String s ;
        StringBuffer sb = new StringBuffer() ;
        while((s = reader.readLine()) != null) {
            sb.append(s) ;
            sb.append("\n") ;
            if(s.matches(regex)) {
                list.add(s) ;
            }
        }

        reader.close();

        return sb.toString() ;
    }

    @Test
    public void test1() {
        try {
            System.out.println(read("D:/crawler.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            read2("D:/crawler.txt") ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.reverse(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        try {
            read3("D:/crawler.txt") ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test4() {
        try {
            read4("D:/crawler.txt",".*ch.*") ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

}
