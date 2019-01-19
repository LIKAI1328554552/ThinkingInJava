package com.likai.chapter18;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024 ;
    public static void main(String [] args) {

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE) ;

        int i = 0 ;
        //缓冲器的大小
        while(i ++ < buffer.limit()) {
            System.out.println("nonzero");
        }

        System.out.println("i = " + i);

        //回到起点
        buffer.rewind() ;

        buffer.asCharBuffer().put("Howdy!") ;
        char c ;
        while((c = buffer.getChar()) != 0) {
            System.out.println(c);
        }

        //回到起点
        buffer.rewind() ;
        //向下转型 可能出现精度丢失
        buffer.asShortBuffer().put((short)471142) ;
        System.out.println(buffer.getShort());

        //回到起点
        buffer.rewind() ;
        buffer.asIntBuffer().put(999999999) ;
        System.out.println(buffer.getInt());

        //回到起点
        buffer.rewind() ;
    }

}
