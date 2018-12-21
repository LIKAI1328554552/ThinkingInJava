package com.likai.chapter18.pratice;

import com.likai.util.TextFile;

import java.util.*;

public class Test6 {
    public static void main(String [] args) {
        String fileName = "D:/workspace_idea/ThinkingInJava/src/main/java/com/likai/chapter01/practice/AllTheColorsOfRainbow.java" ;
        //将文件内容转换成字符数组
        char [] ca = TextFile.read(fileName).toCharArray() ;

        Set<Character> charSet = new TreeSet<Character>() ;
        for (char c : ca) {
            charSet.add(c) ;
        }

        List<Character> charList = new ArrayList<Character>() ;
        for (char c : ca) {
            charList.add(c) ;
        }

        Map<Character,Integer> map = new HashMap<Character, Integer>() ;
        for (Character character : charSet) {
            int count = 0 ;
            for (Character character1 : charList) {
                if(character1.equals(character)) {
                    count ++ ;
                }
            }
            map.put(character,count) ;
        }

        System.out.println(map);

    }
}
