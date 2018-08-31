package com.likai.chapter05.practice;

/**
 * Created by likai on 2018/08/06.
 */
class InitTest {
    InitTest(String s) {
        System.out.println("InitTest()");
        System.out.println(s);
    }
}

public class Test3 {
    public static void main(String[] args) {
        InitTest[] it = new InitTest[]{
                new InitTest("1"),
                new InitTest("2"),
                new InitTest("3"),
                new InitTest("4"),
                new InitTest("5"),
                new InitTest("6"),
                new InitTest("7"),
        };
    }
}
