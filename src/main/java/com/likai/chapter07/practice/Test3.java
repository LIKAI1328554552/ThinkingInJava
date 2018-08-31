package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/12.
 */
class Person {
    public void eat() {
        System.out.println("吃");
    }
    public void sleep() {
        System.out.println("睡");
    }
    public void sports() {
        System.out.println("运动");
    }
}
class Student extends Person {
    /*public void sports(int time) {
        System.out.println("运动 " + time + "个小时");
    }*/

    public void eat() {
        System.out.println("学生吃");
    }
    public void sleep() {
        System.out.println("学生睡");
    }
    public void sports() {
        System.out.println("学生运动");
    }
}
public class Test3 {
    public static void main(String [] args) {
        Person person = new Student() ;
        person.eat();
        person.sleep();
        person.sports();
    }

}
