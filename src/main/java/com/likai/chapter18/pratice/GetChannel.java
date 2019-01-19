package com.likai.chapter18.pratice;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024 ;
    public static void main(String [] args) throws Exception {
        String outfilePath = "D:" + File.separator + "Data1.txt" ;
        String infilePath = "D:" + File.separator + "Data.txt" ;
        //写文件
        FileChannel fc = new FileOutputStream(outfilePath).getChannel() ;

        fc.write(ByteBuffer.wrap("Some text ".getBytes())) ;

        //读写文件
        fc = new RandomAccessFile(infilePath,"rw").getChannel() ;
        //将fc移动到最后
        fc.position(fc.size()) ;
        //在最后添加内容
        fc.write(ByteBuffer.wrap("Some text ".getBytes())) ;
        fc.close();

        //读文件
        fc = new FileInputStream(infilePath).getChannel() ;
        ByteBuffer bb = ByteBuffer.allocate(BSIZE) ;
        fc.read(bb) ;
        //做好读取准备
        bb.flip() ;
        while (bb.hasRemaining()) {
            System.out.println((char)bb.get());
        }
    }

}
