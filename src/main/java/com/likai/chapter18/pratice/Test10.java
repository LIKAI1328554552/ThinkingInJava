package com.likai.chapter18.pratice;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test10 {
    public static final int BSIZE = 1024 ;
    public static void main(String [] args) throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE) ;

        buffer.put("测试字符所占的字节数".getBytes()) ;
        buffer.put("a".getBytes()) ;

        System.out.println("-----------------put-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip() ;
        System.out.println("-----------------flip-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.mark() ;
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");

        buffer.reset() ;
        System.out.println("-----------------reset-------------------");

        System.out.println(buffer.position());

        FileChannel channel = new FileOutputStream("D:/test.txt").getChannel();

    }
}
