package com.likai.chapter18.pratice;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Echo {

    @Test
    public void test1() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;

            String s ;
            while((s = reader.readLine()) != null) {
                System.out.println(s.toUpperCase());
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        //要传入第二个参数 如果不开启自动清空 可能会出现不显示内容的情况
        PrintWriter writer = new PrintWriter(System.out,true) ;
        writer.println("Hello World !");
    }
}
