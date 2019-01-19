package com.likai.chapter21.pratice;

class Test15_1 {
    private Object o1 = new Object() ;
    private Object o2 = new Object() ;
    private Object o3 = new Object() ;
    public void test4() {
        synchronized (o1) {
            for(int i = 0 ; i < 50; i ++) {
                System.out.println("test4()");
                Thread.yield();
            }
        }
    }

    public void test5() {
        synchronized (o2) {
            for(int i = 0 ; i < 50; i ++) {
                System.out.println("test5()");
                Thread.yield();
            }
        }
    }

    public void test6() {
        synchronized (o3) {
            for(int i = 0 ; i < 50; i ++) {
                System.out.println("test6()");
                Thread.yield();
            }
        }
    }
}

public class Test15 {

    public void test1() {
        synchronized (this) {
            for(int i = 0 ; i < 5; i ++) {
                System.out.println("test1()");
                Thread.yield();
            }
        }
    }

    public void test2() {
        synchronized (this) {
            for(int i = 0 ; i < 5; i ++) {
                System.out.println("test2()");
                Thread.yield();
            }
        }
    }

    public void test3() {
        synchronized (this) {
            for(int i = 0 ; i < 5; i ++) {
                System.out.println("test3()");
                Thread.yield();
            }
        }
    }

    public static void main(String [] args) {
        final Test15 t = new Test15() ;
        final Test15_1 t1 = new Test15_1() ;
        new Thread() {
            public void run() {
                t.test1();
            }
        }.start();
        new Thread() {
            public void run() {
                t.test2();
            }
        }.start();
        new Thread() {
            public void run() {
                t.test3();
            }
        }.start();
        new Thread() {
            public void run() {
                t1.test4();
            }
        }.start();
        new Thread() {
            public void run() {
                t1.test5();
            }
        }.start();
        new Thread() {
            public void run() {
                t1.test6();
            }
        }.start();
    }

}
