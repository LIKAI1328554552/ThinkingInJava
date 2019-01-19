package com.likai.util;


import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWord {

    /**
     * 读取word文件内容
     *
     * @param path
     * @return buffer
     */

    public String readWord(String path) {
        String buffer = "";
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static void main(String[] args) {
        ReadWord tp = new ReadWord();
        String content = tp.readWord("D:/test1.docx");
        System.out.println(content);
        System.out.println("----------------------------------");
        System.out.println("-------------拆分线-----------------");
        System.out.println("----------------------------------");
        //拆单位
        String [] contentArrays = content.split("\n") ;
        System.out.println(contentArrays[0]);
        /*for (String contentArray : contentArrays) {
            System.out.println(contentArray);
        }*/


        //拆名字
        //匹配多行
        Pattern pattern = Pattern.compile("^讯问人：.*",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE) ;

        Matcher matcher = pattern.matcher(content) ;


        while (matcher.find()) {
            String line = matcher.group().replaceAll(" ","");
            System.out.println(line);
            String [] array = line.split("[讯问人：|记录人：]") ;
            for (String s : array) {
                String [] names = s.split("[ |，|、]") ;
                for (String name : names) {
                    System.out.println(name);
                }
            }
        }
    }
}
