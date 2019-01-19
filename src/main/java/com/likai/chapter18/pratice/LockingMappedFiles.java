package com.likai.chapter18.pratice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
    public static final int LENGTH = 0x8FFFFFF ;
    public static FileChannel fc ;
    public static void main(String [] args) throws Exception {
        fc = new RandomAccessFile("D:/Data.txt","rw").getChannel() ;

        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for(int i = 0 ; i < LENGTH; i ++) {
            map.put((byte) 'x') ;
        }

        new LockAndModify(map,0,0 + LENGTH / 3) ;
        new LockAndModify(map,LENGTH / 2,LENGTH / 2 + LENGTH / 4) ;

    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buffer ;
        private int start ;
        private int end ;
        public LockAndModify(ByteBuffer mbb,int start,int end) {
            this.start = start ;
            this.end = end ;
            mbb.limit(end) ;
            mbb.position(start) ;
            this.buffer = mbb.slice() ;

            start() ;
        }

        public void run() {
            try {
                //加上阻塞锁
                //阻塞锁 :如果资源被占用 将一直阻塞进程直到获取到资源
                //非阻塞锁: 如果资源被占用 他将直接从调用方法处返回
                FileLock fl = fc.lock(start,end,false) ;
                System.out.println("Locked: " + start + " to " + end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1)) ;
                }
                fl.release();
                System.out.println("Released: " + start + " to " + end);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
