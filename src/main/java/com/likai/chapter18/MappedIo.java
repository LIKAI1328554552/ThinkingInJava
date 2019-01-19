package com.likai.chapter18;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedIo {

    private static int numOfInts = 4000000 ;
    private static int numOfUbffInts = 200000 ;

    private abstract static class Tester {
        private String name ;
        public Tester(String name) {
            this.name = name ;
        }

        public void runTest() {
            System.out.println(this.name + ": ");
            try {
                long start = System.nanoTime() ;
                test() ;
                double duration = System.nanoTime() - start ;
                System.out.println(duration/1.0e9);
            } catch (Exception e) {

            }
        }

        public abstract void test() throws Exception ;
    }

    private static Tester [] testers = {
            new Tester("Stream Writer") {
                @Override
                public void test() throws Exception {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:/temp.tmp")));
                    for(int i = 0 ; i < numOfInts; i ++) {
                        dataOutputStream.write(i);
                    }

                    dataOutputStream.close();

                }
            },
            new Tester("Mapped Writer") {
                @Override
                public void test() throws Exception {
                    FileChannel w = new RandomAccessFile("D:/temp.tmp", "rw").getChannel();
                    MappedByteBuffer intBuffer = w.map(FileChannel.MapMode.READ_WRITE,0,w.size()) ;
                    for(int i = 0 ; i < numOfInts; i ++) {
                        intBuffer.put((byte) i) ;
                    }
                    w.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws Exception {
                    DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("D:/temp.tmp")));

                    for(int i = 0 ; i < numOfInts; i ++) {
                        inputStream.readInt() ;
                    }

                    inputStream.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws Exception {
                    FileChannel channel = new FileInputStream(new File("D:/temp.tmp")).getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
                    while (map.hasRemaining()) {
                        map.get() ;
                    }

                    channel.close();

                }
            },
            new Tester("Stream Read/Writer") {
                @Override
                public void test() throws Exception {
                    RandomAccessFile rw = new RandomAccessFile("D:/temp.tmp", "rw");
                    rw.writeInt(1);
                    for(int i = 0 ; i < numOfUbffInts; i ++) {
                        rw.seek(rw.length() - 4);
                        rw.writeInt(rw.readInt());
                    }

                    rw.close();
                }
            },
            new Tester("Mapped Read/Writer") {
                @Override
                public void test() throws Exception {
                    FileChannel rw = new RandomAccessFile("D:/temp.tmp", "rw").getChannel();
                    IntBuffer intBuffer = rw.map(FileChannel.MapMode.READ_WRITE, 0, rw.size()).asIntBuffer();

                    intBuffer.put(0) ;
                    for(int i = 1 ; i < numOfUbffInts; i ++) {
                        intBuffer.put(intBuffer.get(i - 1)) ;
                    }

                    rw.close();

                }
            }
    } ;

    public static void main(String [] args) {
        for (Tester tester : testers) {
            tester.runTest();
        }
    }


}
