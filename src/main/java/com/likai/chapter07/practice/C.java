package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/11.
 */
public class C extends A {
    private B b ;
    public C() {
        super(11);
        this.b = new B(22) ;
    }
    public static void main(String [] args) {
        C c = new C() ;
    }
}
