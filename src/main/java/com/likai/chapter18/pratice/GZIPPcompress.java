package com.likai.chapter18.pratice;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPPcompress {
    public static void main(String [] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("D:/Data.txt")) ;

        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("D:/Data.gz")));

        System.out.println("writer file");
        int c ;
        while((c = in.read()) != -1) {
            out.write(c);
        }

        in.close();
        out.close();
        System.out.println("read file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("D:/Data.gz")))) ;
        String s ;
        while((s = in2.readLine()) != null) {
            System.out.println(s);
        }
        in2.close();
    }
}
