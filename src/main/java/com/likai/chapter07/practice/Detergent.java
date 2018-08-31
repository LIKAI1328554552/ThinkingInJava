package com.likai.chapter07.practice;

import com.likai.util.Print;

/**
 * Created by likai on 2018/08/11.
 */
public class Detergent extends Cleanser{

    public Detergent() {
        super() ;
        System.out.println("Detergent的构造方法");
    }
    /**
     * 覆盖父类方法
     */
    public void scrub() {
        append("Detergent.scrub()") ;
        super.scrub();
    }

    public void form() {
        append("form()");
    }
    public static void main(String [] args) {
        Detergent d = new Detergent() ;
        d.dilute();
        d.apply();
        d.scrub();
        d.form();
        System.out.println(d);
        System.out.println("===============================================");
        Cleanser.main(args);
    }

}
