package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/11.
 */
public class Test2 {
    private Test1 test ;
    public Test2() {
        System.out.println("Test2构造函数");
        if(test == null) {
            test = new Test1() ;
        }
        System.out.println(test.getS());
    }

    public static void main(String [] args) {
        Test2 t = new Test2() ;
    }
}
