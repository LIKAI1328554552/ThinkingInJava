package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
class Person {
    private int x ;
    private int x() {
        return 1;
    }
}
public class Test1 {
    private String test ;

    public Test1(String s) {
        this.test = s ;
    }

    public String toString() {
        return this.test ;
    }

    public static void main(String [] args) {
        Person p = new Person() ;
        Sequence sequence = new Sequence(10) ;
        for(int i = 0 ; i < 10; i ++) {
            sequence.add(new Test1("test" + i));
        }

        Selector selector = sequence.selector() ;
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
