package com.likai.chapter13.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by likai on 2018/11/10.
 * 代理模式
 */
interface Interface {
    public void doSomething() ;
    public void somethingElse(String str) ;
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething!!!");
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("somethingElse" + str);
    }
}

/**
 * 普通代理类
 */
class ProxyObject implements Interface {
    private Interface proxied ;

    //统计dosomething方法调用次数
    private static int dsNum ;

    //统计somethingElse方法调用次数
    private static int seNum ;

    public ProxyObject(Interface proxied) {
        this.proxied = proxied ;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        this.proxied.doSomething();
        this.dsNum ++ ;
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("simpleProxy somethingElse" + str);
        this.proxied.somethingElse(str);
        this.seNum ++ ;
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface proxied) {
        proxied.doSomething();
        proxied.somethingElse("hello world");
    }

    public static void main(String [] args) {
        consumer(new RealObject());
        consumer(new ProxyObject(new RealObject()));
    }

}
