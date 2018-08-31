package com.likai.chapter08;

import java.util.Random;

/**
 * Created by likai on 2018/08/22.
 */
public class RandomDoubles {
    private static Random rand = new Random(47) ;
    public double next() {
        return rand.nextDouble() ;
    }

    public static void main(String [] args) {
        RandomDoubles a = new RandomDoubles() ;
        System.out.println(a.next());
    }
}
