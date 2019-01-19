package com.likai.chapter21.pratice;

import org.junit.Test;

class TestTask implements Runnable {

    public TestTask() {
        super();
        System.out.println("启动");
    }

    @Override
    public void run() {
        System.out.println("消息1");
        Thread.yield();
        System.out.println("消息2");
        Thread.yield();
        System.out.println("消息3");
        Thread.yield();

        System.out.println("关闭");
    }
}
public class Test1  {

    public static void main(String [] args) {
        for(int i = 0 ; i < 100; i ++) {
            new Thread(new TestTask()) .start();
        }
    }


}
