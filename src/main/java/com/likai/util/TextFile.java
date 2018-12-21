package com.likai.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * create by 2018/12/19 likai
 * 文件读写工具类
 */
public class TextFile extends ArrayList<String> {

    public TextFile(String fileName) {
        this(fileName,"\n") ;
    }

    public TextFile(String fileName,String splitter) {
        super(Arrays.asList(read(fileName).split(splitter))) ;
    }

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder() ;
        BufferedReader in = null ;
        try {
            //创建缓存字符流对象
            in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile())) ;

            String s ;
            while((s = in.readLine()) != null) {
                sb.append(s) ;
                sb.append("\n") ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString() ;
    }

    public static void write(String fileName,String text) {
        PrintWriter out = null ;
        try {
            //默认会使用缓存字符流
            out = new PrintWriter(new File(fileName).getAbsoluteFile()) ;

            out.write(text);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    public void write(String fileName) {
        PrintWriter out = null ;
        try {
            out = new PrintWriter(new File(fileName).getAbsoluteFile()) ;

            for (String item : this) {
                out.println(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static void main(String [] args) {
        /*String s = TextFile.read("D:/crawler.txt") ;
        System.out.println(s);*/

        /*TextFile.write("D:/1111.txt","测试测试测试");*/
        TextFile list = new TextFile("D:/crawler.txt") ;
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
