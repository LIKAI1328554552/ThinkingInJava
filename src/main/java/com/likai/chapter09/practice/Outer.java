package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class Outer {

    private String s ;

    public void setS(String s) {
        this.s = s ;
    }

    class Inner {
        Inner() {
            System.out.println("Hello World!");
        }

        public String toString() {
            return s ;
        }
    }

    public Inner inner() {
        return new Inner() ;
    }

    public static void main(String [] args) {
        Outer outer = new Outer() ;
        outer.setS("likai");
        Inner inner = outer.inner() ;
        System.out.println(inner.toString());
    }
}
