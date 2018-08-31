package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/14.
 */
class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private void g() {
        System.out.println("WithFinals.g()");
    }
}
class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }

}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }
    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }

}
public class FinalOverridingLllusion {
    public static void main(String [] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2() ;
        op2.f();
        op2.g();
        //向上转型
        OverridingPrivate op = op2 ;
        //op.f() ;
    }
}
