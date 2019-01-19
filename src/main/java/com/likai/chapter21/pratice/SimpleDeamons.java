package com.likai.chapter21.pratice;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程的介绍:
 *  是指在程序运行的时候在后台提供的一种通用服务线程,并且这种线程不属于程序中不可或缺的部分
 *  当所有的非后台线程(mian()) 结束时 程序也就终止了 同时会杀死进程中的所有后台线程
 */
public class SimpleDeamons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " : " + this);
            }

        } catch (Exception e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String [] args) throws InterruptedException {
        //创建后台线程
        for(int i = 0 ; i < 10; i ++) {
            Thread deamon = new Thread(new SimpleDeamons()) ;
            deamon.setDaemon(true);
            deamon.start();
        }

        System.out.println("All deamons started");
        //让main() 非后台线程休息一段时间
        //否则main线程结束 非后台线程可能并没有执行完就终止了
        TimeUnit.MICROSECONDS.sleep(175);
    }
}
