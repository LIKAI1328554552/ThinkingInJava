package com.likai.chapter06.practice;

import static com.likai.util.Print.*;
import static com.likai.util.Range.*;

/**
 * Created by likai on 2018/08/07.
 */

public class Test1 {
    public static void main(String [] args) {
        for (int i : range(1,15,3)) {
            print(i);
            System.out.println("Hello World");
        }

        Person person = new Person() ;
        person.personPrint();
    }


}
