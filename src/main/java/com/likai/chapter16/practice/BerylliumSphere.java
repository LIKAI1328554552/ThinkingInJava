package com.likai.chapter16.practice;

/**
 * Created by likai on 2018/11/11.
 */
public class BerylliumSphere {
    private static long counter ;
    private final long id = counter ++ ;

    public String toString() {
        return "Sphere " + this.id ;
    }

}
