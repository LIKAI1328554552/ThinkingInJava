package com.likai.chapter11.practice;

/**
 * Created by likai on 2018/10/21.
 */
public class Command {
    private String  str ;

    public Command(String str) {
        super() ;
        this.str = str ;
    }

    public void operation() {
        System.out.println(this.str);
    }
}
