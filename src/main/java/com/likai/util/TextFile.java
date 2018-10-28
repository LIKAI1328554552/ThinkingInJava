package com.likai.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by likai on 2018/10/27.
 */
public class TextFile extends ArrayList<String> {

    public TextFile() {
        super();
    }

    /**
     * 有参构造
     * @param fileName
     * @param splitter
     */
    public TextFile(String fileName,String splitter) {
        //读取文件内容并使用分隔符拆分
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) {
            remove(0) ;
        }
    }

    /**
     * 有参构造
     * @param fileName
     */
    public TextFile(String fileName) {
        this(fileName,"\n") ;
    }

    /**
     * 读取文件内容为字符串
     * @param fileName
     * @return
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder() ;
        BufferedReader in = null ;
        try {
             in = new BufferedReader(new FileReader(new File("D:" + File.separator + fileName))) ;
            String s = null ;
            while((s = in.readLine()) != null) {
                sb.append(s) ;
                sb.append("\n") ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString() ;
    }

    /**
     * 写文件
     * @param fileName
     */
    public void write(String fileName) {
        PrintWriter writer = null ;
        try {
            writer = new PrintWriter(new File("D:" + File.separator + fileName)) ;
            //this:对象本身
            for (String item : this) {
                writer.print(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    /**
     * 写文件
     * @param fileName
     * @param text
     */
    public static void write(String fileName,String text) {
        PrintWriter writer = null ;
        try {
            writer = new PrintWriter(new File("D:" + File.separator + fileName)) ;
            writer.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
