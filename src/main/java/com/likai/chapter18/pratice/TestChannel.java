package com.likai.chapter18.pratice;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    public static final int BSIZE = 1024 ;


    /**
     * 使用通道完成文件的复制
     */
    @Test
    public void test1() throws Exception {
        String filePath = "D:" + File.separator + "crawler.txt" ;
        String copy_filePath = "D:" + File.separator + "crawler1.txt" ;
        FileChannel inChannel = new FileInputStream(filePath).getChannel();
        FileChannel outChannel = new FileOutputStream(copy_filePath).getChannel() ;

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (inChannel.read(buffer) != -1) {
            buffer.flip() ;
            outChannel.write(buffer) ;
            buffer.clear() ;
        }

    }

    /**
     * 使用通道视图完成文件数据载入
     */
    @Test
    public void test1_1() throws Exception {
        String filePath = "D:" + File.separator + "crawler.txt" ;
        FileChannel inChannel = new FileInputStream(filePath).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        inChannel.read(buffer) ;
        buffer.flip() ;
        System.out.println(buffer.asCharBuffer());

    }

    /**
     * 使用直接缓冲区复制文件(内存映射文件)
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        String filePath = "D:" + File.separator + "crawler.txt" ;
        String copy_filePath = "D:" + File.separator + "crawler2.txt" ;
        FileChannel inChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ);
        //注意点1 : 因为map中给予outChannel的模式是读写模式 所以此处也要多声明读模式
        //否则会出现 不能读异常
        FileChannel outChannel = FileChannel.open(Paths.get(copy_filePath), StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE);
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size()) ;
        System.out.println(inChannel.size());
        System.out.println(outChannel.size());
        //注意点2 : 此处设置map的大小时 也设置成输入数据的通道大小
        //因为如果copy_filePath文件不存在时 那么他的size就是为0
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //创建一个包含全部数据的byte数组
        byte [] bArray = new byte[inMapped.limit()] ;
        //获取数据到byte数组
        inMapped.get(bArray) ;
        //将byte数组中的数据写出
        outMapped.put(bArray) ;

        outChannel.close();
        inChannel.close();

    }


}
