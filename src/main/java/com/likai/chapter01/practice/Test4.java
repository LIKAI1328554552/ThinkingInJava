package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/02.
 */
public class Test4 {

    public static void main(String [] args) {
        System.out.println(StaticTest.i);
        /**
         * 对象的实例 也可以引用静态资源
         */
        System.out.println("StaticTest.i= " + StaticTest.i);
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println("st1.i= " + st1.i);
        System.out.println("st2.i= " + st2.i);

        Incrementtable.increment();


        System.out.println("StaticTest.i= " + StaticTest.i);
        System.out.println("st1.i= " + st1.i);
        System.out.println("st2.i= " + st2.i);

    }
}
