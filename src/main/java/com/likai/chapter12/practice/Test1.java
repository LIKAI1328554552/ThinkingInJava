package com.likai.chapter12.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by likai on 2018/10/24.
 */
public class Test1 {

    public static void main(String [] args) {
        String content = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!" ;
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("+5678".matches("[-|\\+]?\\d+"));
        System.out.println("Ah dsdsd 99999!".matches("^[A-Z].*\\.$"));
        String [] p1 = content.split("(the|you)") ;
        for (String s : p1) {
            System.out.println(s);
        }

        System.out.println(content.replaceAll("[aeiouAEIOU]","_"));

    }
}
