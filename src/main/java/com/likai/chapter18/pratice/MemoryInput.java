package com.likai.chapter18.pratice;

import java.io.BufferedInputStream;
import java.io.StringReader;

public class MemoryInput {

    public static void main(String [] args) throws Exception {
        StringReader reader = new StringReader(BufferedInputFile.read("D:/crawler.txt")) ;
        //字节
        int c ;
        while((c = reader.read()) != -1) {
            //将字节装换成为char字符
            System.out.println((char)c);
        }
    }
}
