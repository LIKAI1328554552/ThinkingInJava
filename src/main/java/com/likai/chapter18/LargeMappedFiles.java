package com.likai.chapter18;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {

    public static int length = 0x8FFFFFF ;
    public static void main(String [] args) throws Exception {
        MappedByteBuffer mbb =
                new RandomAccessFile("d:" + File.separator + "text.dat", "rw")
                        .getChannel()
                        .map(FileChannel.MapMode.READ_WRITE,0,length);
        
        for(int i = 0 ; i < length; i ++) {
            mbb.put((byte) 'x') ;
        }

        System.out.println("写完了!!!");
        for(int i = length / 2 ; i < length / 2 + 6; i ++) {
            System.out.println((char)mbb.get(i));
        }

    }

}
