package com.likai.chapter08.practice;

/**
 * Created by likai on 2018/08/14.
 */

class AA {
    public void test1() {
        System.out.println("A.test1()");
        test2();
    }

    public void test2() {
        System.out.println("A.test()2");
    }
}

class BB extends AA {
    @Override
    public void test2() {
        System.out.println("B.test2()");
    }
}
public class Test2 {
    public static void main(String [] args) {
        AA aa = new BB() ;
        aa.test1();
    }
}
