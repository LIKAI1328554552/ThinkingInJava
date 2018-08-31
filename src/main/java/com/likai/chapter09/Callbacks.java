package com.likai.chapter09;

import com.likai.chapter01.practice.Incrementtable;

/**
 * Created by likai on 2018/08/27.
 */


class Callee1 implements Incrementable {
    private int i ;
    @Override
    public void increment() {
        i ++ ;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other Operation");
    }

    public static void f(MyIncrement increment) {
        increment.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i ;
    public void increment() {
        super.increment();
        i ++ ;
        System.out.println(i);
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    public Incrementable getCallbackReference() {
        return new Closure() ;
    }
}
class Caller {
    private Incrementable callbackReference ;
    Caller(Incrementable incrementable) {
        this.callbackReference = incrementable ;
    }
    void go() {
        callbackReference.increment();
    }
}
public class Callbacks {

    public static void main(String [] args) {
        Callee1 c1 = new Callee1() ;
        Callee2 c2 = new Callee2() ;
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1) ;
        Caller caller2 = new Caller(c2.getCallbackReference()) ;
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
