package com.likai.chapter06.practice;

/**
 * Created by likai on 2018/08/07.
 */
public class Person {
    private String name ;
    private String sex ;
    protected int age ;
    int a ;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    protected void personPrint() {
        System.out.println("111");
    }

}
