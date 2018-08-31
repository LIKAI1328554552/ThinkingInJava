package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/11.
 */
public class Cleanser {

    private String s = "Cleanser" ;

    public Cleanser() {
        super() ;
        System.out.println("Cleanser的构造方法");
    }

    public void append(String a) {
        this.s += a ;
    }

    public void dilute() {
        append("dilute()");
    }
    public void apply() {
        append("apply()");
    }
    public void scrub() {
        append("scrub()");
    }

    public String toString() {
        return this.s ;
    }

    public static void main(String [] args) {
        Cleanser x = new Cleanser() ;
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}
