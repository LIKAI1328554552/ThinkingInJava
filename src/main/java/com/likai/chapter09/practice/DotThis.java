package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class DotThis {
    public void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this ;
            /*return new DotThis() ;*/
        }
    }

    public Inner inner() {
        return new Inner() ;
    }

    public static void main(String [] args) {
        DotThis dotThis = new DotThis() ;
        /*Inner inner = dotThis.inner();*/
        Inner inner = dotThis.new Inner() ;
        inner.outer().f();
    }
}
