package com.likai.chapter18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark() ;
            char c1 = buffer.get() ;
            char c2 = buffer.get() ;

            buffer.reset() ;

            buffer.put(c2).put(c1) ;

        }
    }

    public static void main(String [] args) {
        char [] data = "UsingBuffers".toCharArray() ;
        ByteBuffer b = ByteBuffer.allocate(data.length * 2) ;
        CharBuffer c = b.asCharBuffer() ;
        c.put(data) ;

        System.out.println(c.rewind());

        symmetricScramble(c);

        System.out.println(c.rewind());

        symmetricScramble(c);

        System.out.println(c.rewind());

    }

}
