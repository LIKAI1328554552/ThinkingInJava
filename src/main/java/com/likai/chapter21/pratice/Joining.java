package com.likai.chapter21.pratice;

/**
 * 加入一个线程
 * 线程(Joiner)可以在其他线程(Sleeper)之上调用join()方法 其效果是(Joiner)先等待一段时间(挂起) 直到(Sleeper)执行完才继续执行
 * join() 方法也可以提前运行 就是(Sleeper)线程中断 调用interrupt()方法 (Joiner)就可以运行了
 */
class Sleeper extends Thread {
    private int duration ;
    public Sleeper (String name,int sleepTime) {
        super(name);
        duration = sleepTime ;
        start();
    }
    public void run() {
        try {
            sleep(duration) ;
        } catch (Exception e) {
            System.out.println(getName() + " was interrupted.  isInterrupted() :" + isInterrupted());
            return ;
        }

        System.out.println(getName() + " has awakened");
    }
}
class Joiner extends Thread {
    private Sleeper sleeper ;
    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper ;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(getName() + " join completed");
    }
}
public class Joining {

    public static void main(String [] args) {
        Sleeper sleeper = new Sleeper("Sleeper",1500) ;
        Sleeper grumpy = new Sleeper("Grumpy",1500) ;
        Joiner dopey = new Joiner("Dopey",sleeper) ;
        Joiner doc = new Joiner("Doc",grumpy) ;

        /*grumpy.interrupt();*/

    }
}
