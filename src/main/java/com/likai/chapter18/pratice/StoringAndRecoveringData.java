package com.likai.chapter18.pratice;

import org.junit.Test;

import java.io.*;

public class StoringAndRecoveringData {
    @Test
    public void test1() throws Exception {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:/Data.txt"))) ;

        out.writeDouble(3.1415);
        out.writeUTF("That was pi");
        out.writeDouble(1.111112);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:/Data.txt"))) ;

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

        in.close();

    }

    @Test
    public void test2() throws Exception {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:/Data.txt"))) ;

        out.writeDouble(3.1415);
        out.writeUTF("That was pi");
        out.writeBoolean(true);
        out.writeByte(220);
        out.writeChar('a');
        out.writeFloat((float) 1.1);
        out.writeInt(1);
        out.writeLong(11111);
        out.writeShort(111);

        out.writeDouble(1.111112);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:/Data.txt"))) ;

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
        System.out.println(in.readChar());
        System.out.println(in.readFloat());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readShort());


        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

        in.close();
    }
}
