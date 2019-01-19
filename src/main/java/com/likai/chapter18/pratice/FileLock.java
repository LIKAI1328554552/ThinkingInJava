package com.likai.chapter18.pratice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

public class FileLock {
    public static void main(String [] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:/Data1.txt") ;

        java.nio.channels.FileLock lock = fos.getChannel().tryLock() ;
        if(lock != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            lock.release();
            System.out.println("Released Lock");
        }

        fos.close();

    }
}
