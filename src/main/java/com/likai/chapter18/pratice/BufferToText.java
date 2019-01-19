package com.likai.chapter18.pratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024 ;

    public static void main(String [] args) throws Exception {

        String filePath = "D:" + File.separator + "Data1.txt" ;
        String filePath2 = "D:" + File.separator + "Data2.txt" ;

        FileChannel fc = new FileOutputStream(filePath).getChannel() ;

        fc.write(ByteBuffer.wrap("Some text".getBytes())) ;

        fc.close();

        //-----------------------------------

        fc = new FileInputStream(filePath).getChannel() ;

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE) ;
        fc.read(buffer) ;
        buffer.flip() ;
        System.out.println(buffer.asCharBuffer());

        //返回到数据的开位置始
        buffer.rewind() ;


        String encoding = System.getProperty("file.encoding") ;
        System.out.println("Decoded using " + encoding + " :" + Charset.forName(encoding).decode(buffer));

        System.out.println("-----------------------------------------------------");

        fc = new FileOutputStream(filePath2).getChannel() ;

        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE"))) ;
        fc.close();

        System.out.println("-----------------------------------------------------");


        fc = new FileInputStream(filePath2).getChannel() ;
        buffer.clear() ;
        fc.read(buffer) ;
        buffer.flip() ;
        System.out.println(buffer.asCharBuffer());

        System.out.println("---------------------------------");

        fc = new FileOutputStream(filePath2).getChannel() ;
        buffer = ByteBuffer.allocate(24) ;
        buffer.asCharBuffer().put("Some text") ;
        fc.write(buffer) ;
        fc.close();

        System.out.println("------------------------------------------------------------");

        fc = new FileInputStream(filePath2).getChannel() ;
        buffer.clear() ;
        fc.read(buffer) ;
        buffer.flip() ;
        System.out.println(buffer.asCharBuffer());


    }
}
