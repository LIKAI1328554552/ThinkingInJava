package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/09/19.
 */
public class BenChi implements Car {
    @Override
    public void setLt() {
        System.out.println("我是奔驰的轮胎");
    }

    @Override
    public void setMm() {
        System.out.println("我是奔驰的门子");
    }
}
