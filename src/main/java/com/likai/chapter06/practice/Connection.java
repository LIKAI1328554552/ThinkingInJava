package com.likai.chapter06.practice;

/**
 * Created by likai on 2018/08/09.
 */
public class Connection {

    public static int count = 0 ;
    private int i = 0 ;
    private Connection() {

    }
    static Connection createInstance() {
        count ++ ;
        return new Connection() ;
    }

    public static int count() {
        return count ;
    }

}
