package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/11/10.
 * 代理模式
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied ;

    public DynamicProxyHandler(Interface proxied) {
        this.proxied = proxied ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("******proxy: " + proxy.getClass() + " ,method: " + method + " ,args:" + args);
        if(args != null) {
            for (Object arg : args) {
                System.out.println("   " + arg);
            }
        }
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface proxied) {
        proxied.doSomething();
        proxied.somethingElse("hello world");
    }

    public static void main(String [] args) {
        RealObject realObject = new RealObject() ;
        consumer(realObject) ;
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(realObject));
        consumer(proxy);
    }
}
