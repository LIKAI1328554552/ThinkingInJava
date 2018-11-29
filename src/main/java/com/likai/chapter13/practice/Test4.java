package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/11/04.
 */

class Person {
    public void bark() {
        System.out.println("ceshi");
    }
}

class Student extends Person{

}

public class Test4 {
    public static void main(String [] args) {
        /*//多态
        Person p = new Student() ;

        Student student = new Student() ;
        //向上转型(安全)
        Person p = student ;

        Person p = new Person() ;
        //向下转型(不安全强制类型转换)
        Student s = (Student) p;*/

        Student s = new Student() ;

        if(s instanceof Person) {
            ((Person) s).bark();
        }
    }
}
