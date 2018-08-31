package com.likai.chapter05.practice;

/**
 * Created by likai on 2018/08/05.
 */
public class Test1 {

    public String str = "11111" ;

    public Test1() {
        super() ;
        System.out.println(str);
        this.str = "222222222" ;
    }

    public static void main(String [] args) {
        Test1 test = new Test1() ;
        System.out.println(test.str);
    }
}
