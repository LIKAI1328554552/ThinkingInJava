package com.likai.chapter18.pratice;

import java.io.*;

public class Test5 {
    public static void main(String [] args) throws IOException {
        InputStream in = new FileInputStream(new File("D:/crawler.txt")) ;

        int s ;
        StringBuffer stringBuffer = new StringBuffer() ;
        while((s = in.read()) != -1) {
            System.out.println((char) s);
        }
    }
}
