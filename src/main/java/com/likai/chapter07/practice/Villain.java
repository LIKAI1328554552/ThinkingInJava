package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/12.
 */
public class Villain {
    private String name ;

    public Villain(String name) {
        this.name = name ;
    }
    protected void setName(String name) {
        this.name = name ;
    }

    public String toString() {
        return "Villain 名字为:" + this.name ;
    }
}
