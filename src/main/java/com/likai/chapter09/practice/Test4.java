package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/26.
 */
abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor i = " + i);
    }

    public abstract void f() ;
}
public class Test4 {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance init");
            }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        } ;
    }
    public static void main(String [] args) {
        Base base = Test4.getBase(11) ;
        base.f();
    }
}
