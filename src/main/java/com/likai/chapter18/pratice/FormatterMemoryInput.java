package com.likai.chapter18.pratice;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class FormatterMemoryInput {
    public static void main(String [] args) {

        try {

            DataInputStream in =
                    new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("D:/crawler.txt").getBytes())) ;

            /*while(true) {
                System.out.println((char) in.readByte());
            }*/

            while (in.available() != 0) {
                System.out.println((char) in.readByte());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
