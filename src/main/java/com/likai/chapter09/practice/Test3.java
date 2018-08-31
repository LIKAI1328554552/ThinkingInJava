package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class Test3 implements Contents {
    private int i = 7 ;
    @Override
    public int value() {
        return this.i;
    }

    public static void main(String [] args) {
        Contents c = new Test3() ;

    }
}
