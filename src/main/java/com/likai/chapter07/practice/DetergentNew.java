package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/11.
 */
public class DetergentNew extends Detergent{

    public DetergentNew() {
        System.out.println("DetergentNew的构造函数");
    }

    public void scrub() {
        System.out.println("DetergentNew.scrub()");
        super.scrub() ;
    }

    public void sterilize() {
        append("sterilize()") ;
    }

    public static void main(String [] args) {
        DetergentNew n = new DetergentNew() ;

    }
}
