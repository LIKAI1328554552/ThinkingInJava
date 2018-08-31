package com.likai.chapter08.practice;

/**
 * Created by likai on 2018/08/14.
 */
class Cycle {
    public Cycle() {
        super() ;
    }

    public static void print(int i) {
        System.out.println("Cycle.print()");
    }
}
class Unicycle extends Cycle {
    public Unicycle() {
        super() ;
    }

    public static void print(int i) {
        System.out.println("Unicycle.print("+i+")");
    }
}
class Bicycle extends Cycle {
    public Bicycle() {
        super() ;
    }
    public static void print(int i) {
        System.out.println("Bicycle.print("+i+")");
    }
}

class A {
    public void test(Cycle cycle) {
        cycle.print(22);
    }
}
public class Test1 {
    public static void main(String [] args) {
        A a = new A() ;
        a.test(new Bicycle());
        a.test(new Unicycle()) ;
    }
}
