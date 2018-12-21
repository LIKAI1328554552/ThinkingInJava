package com.likai.chapter18.pratice;

import org.junit.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BasicFileOutput {
    public static void main(String [] args) throws Exception {

        String filepath = "D:/testIo.txt" ;

        BufferedReader reader = new BufferedReader(new FileReader("D:/crawler.txt")) ;

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filepath))) ;

        int lineCount = 1 ;

        String s ;
        while((s = reader.readLine()) != null) {
            writer.println((lineCount ++) + ": " + s);
        }

        writer.close();
        reader.close();

        System.out.println(BufferedInputFile.read(filepath));

    }

    @Test
    public void test1() {
        try {
            String filepath = "D:/testIo.txt" ;

            List<String> list = new LinkedList<String>() ;

            BufferedReader reader = new BufferedReader(new FileReader("D:/crawler.txt")) ;

            //快捷写法已经进行了缓存修饰
            PrintWriter writer = new PrintWriter(filepath) ;

            String s ;
            int lineCount = 1 ;

            while((s = reader.readLine()) != null) {
                list.add((lineCount ++ ) + ": " + s) ;
            }

            reader.close();

            for (String s1 : list) {
                writer.println(s1);
            }

            writer.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        try {
            String filePath = "D:/testIo.txt" ;
            LineNumberReader reader = new LineNumberReader(new FileReader("D:/crawler.txt")) ;

            PrintWriter writer = new PrintWriter(filePath) ;

            String s ;

            while((s = reader.readLine()) != null) {
                writer.println(reader.getLineNumber() + ": " + s);
            }

            writer.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace() ;
        }

    }

    @Test
    public void test3() throws Exception {
        String filePath1 = "D:/testIo1.txt" ;
        String filePath2 = "D:/testIo2.txt" ;

        BufferedReader reader = new BufferedReader(new FileReader("D:/crawler.txt")) ;
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath1))) ;
        String s ;
        long start = System.nanoTime();
        while((s = reader.readLine()) != null) {
            writer.println(s);
        }
        long duration = System.nanoTime() - start;
        writer.close();

        System.out.println("BufferedWriter 花费: " + duration + " 毫秒");



    }

    @Test
    public void test4() throws Exception {
        String filePath2 = "D:/testIo2.txt" ;

        BufferedReader reader = new BufferedReader(new FileReader("D:/crawler.txt")) ;
        PrintWriter writer2 = new PrintWriter(new FileWriter(filePath2)) ;
        String s2 ;
        long start2 = System.nanoTime();
        while((s2 = reader.readLine()) != null) {
            writer2.println(s2);
        }
        long duration2 = System.nanoTime() - start2;
        writer2.close();

        System.out.println("Writer 花费: " + duration2 + " 毫秒");
    }



}
