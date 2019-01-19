package com.likai.chapter18.pratice;

import java.io.*;

public class Redirecting {
    public static void main(String [] args) {
        String inFilePath = "D:" + File.separator + "Data.txt" ;
        String outFilePath = "D:" + File.separator + "Data1.txt" ;
        try {
            //获取标准输出对象
            PrintStream console = System.out ;
            //创建文件输入字符流
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(inFilePath))) ;
            //创建文件输出字节流
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(outFilePath)))) ;

            //把标准输入流重定向到字符输入流上
            System.setIn(in);

            //把标准输出流重定向到字节输出流上
            System.setOut(out);

            //把标准错误流重定向到字节输出流上
            System.setErr(out);

            //将标准输入字节流包装成字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

            String s ;

            while((s = br.readLine()) != null) {
                //将文件内容输出(因为标准输出流已经重定向为out 因此会把输入流的内容 输出到文件中)
                System.out.println(s);
            }

            out.close();
            //再次重定向会标准输出流
            System.setOut(console);
            System.out.println("输出完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
