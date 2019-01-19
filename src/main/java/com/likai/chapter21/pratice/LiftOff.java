package com.likai.chapter21.pratice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {

    protected int countDown = 10 ;
    private static int taskCount = 0 ;
    private final int id = taskCount ++ ;
    public LiftOff() {
        super();
    }

    public LiftOff(int countDown) {
        this.countDown = countDown ;
    }

    public String status() {
        return "#" + this.id + "(" + (countDown > 0 ? countDown : "Liftoff!" ) + ") " ;
    }



    @Override
    public void run() {
        while(this.countDown -- > 0) {
            System.out.println(status());
            //对线程调度器的一种建议,表示我已经完成生命周期中最重要的部分了 此时正是切换线程的大好时机
            Thread.yield();
        }
    }
    public static void main(String [] args) {
        //此写法并不会调用线程
        /*LiftOff off = new LiftOff() ;
        off.run();*/

        //要实现线程行为 必须显示的讲一个任务附着到线程上
        /*Thread thread = new Thread(new LiftOff()) ;
        thread.start();
        System.out.println("Waiting for LiftOff");*/

        //同时启动多个线程 出现线程被换进换出时混在了一起
        /*for(int i = 0 ; i < 5; i ++) {
            Thread thread = new Thread(new LiftOff()) ;
            thread.start();
            System.out.println("Waiting for LiftOff");
        }*/

        //使用1.5之后推出的执行器Executor来启动线程
        //通常会创建于所需数量相同的线程
        /*ExecutorService exec = Executors.newCachedThreadPool() ;*/
        //使用有限的线程来执行任务
        /*ExecutorService exec = Executors.newFixedThreadPool(5) ;*/
        //就像线程为1的newFixedThreadPool 如果提交多个任务那么这些任务将排队 所有任务使用相同的线程
        //这种方式不需要在共享资源上处理同步
        ExecutorService exec = Executors.newSingleThreadExecutor() ;
        for(int i = 0 ; i < 5; i ++) {
            exec.execute(new LiftOff());
        }
        //并不是表示结束执行器 而是防止新的任务被提交给这个执行器
        // (这个程序将在执行器Executor中的所有任务执行结束后尽快的退出)
        exec.shutdown();
    }
}
