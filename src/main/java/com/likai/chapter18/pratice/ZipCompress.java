package com.likai.chapter18.pratice;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    public static void main(String [] args) throws Exception {
        FileOutputStream out = new FileOutputStream("D:/test.zip") ;
        CheckedOutputStream check = new CheckedOutputStream(out,new Adler32()) ;
        ZipOutputStream zip = new ZipOutputStream(check) ;
        BufferedOutputStream bout = new BufferedOutputStream(zip) ;
        zip.setComment("A test of Java Zip");


    }
}
