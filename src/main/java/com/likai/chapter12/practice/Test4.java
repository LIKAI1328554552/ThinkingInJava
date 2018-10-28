package com.likai.chapter12.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by likai on 2018/10/27.
 */
public class Test4 {
    private final static String CONTENT  =
            "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch,\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";
    public static void main(String [] args) {
        /*Pattern pattern = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$") ;
        Matcher matcher = pattern.matcher(CONTENT) ;
        while (matcher.find()) {
            for(int i = 0 ; i <= matcher.groupCount() ; i ++) {
                System.out.print("[" + matcher.group(i) + "]");
            }
            System.out.println(" ");
        }*/
        Pattern pattern = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+") ;
        Matcher matcher = pattern.matcher(CONTENT) ;
        while(matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
