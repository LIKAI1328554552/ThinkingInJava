package com.likai.chapter18.pratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

    private static final int BSIZE = 1024 ;

    public static void main(String [] args) throws Exception {

        String infilePath = "D:" + File.separator + "Data.txt" ;
        String outfilePath = "D:" + File.separator + "Data1.txt" ;
        //通过输出字节流获取管道对象
        FileChannel in = new FileInputStream(infilePath).getChannel() ;
        //通过输入字节流获取管道对象
        FileChannel out = new FileOutputStream(outfilePath).getChannel() ;

        //获取ByteBuffer对象
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE) ;


        while(in.read(buffer) != -1) {
            //准备写
            buffer.flip() ;
            out.write(buffer) ;
            //准备读
            buffer.clear() ;
        }


    }

}
