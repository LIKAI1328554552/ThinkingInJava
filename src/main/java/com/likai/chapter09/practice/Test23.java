package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/27.
 */
interface U {
    public void A() ;
    public void B() ;
    public void C() ;
}

class A {
    public void testA() {

    }

    public U testU() {
        return new U() {
            @Override
            public void A() {

            }

            @Override
            public void B() {

            }

            @Override
            public void C() {

            }
        } ;
    }
}

class B {
    public U [] us ;
    private int i = 0 ;
    public void testB1(U u) {
        us[i] = u ;
        i ++ ;
    }
    public void testB2() {
        this.us = null ;
    }

    public void testB3() {
        for (U u : us) {
            u.A();
            u.B();
            u.C();
        }
    }
}
public class Test23 {
    public static void main(String [] args) {
        B b = new B() ;
        for(int i = 0 ; i < 5; i ++) {
            b.testB1(new A().testU());
        }
    }
}
