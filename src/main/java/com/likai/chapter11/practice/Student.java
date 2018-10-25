package com.likai.chapter11.practice;

import java.util.Iterator;

/**
 * Created by likai on 2018/10/21.
 */
public class Student {

    private String name ;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
