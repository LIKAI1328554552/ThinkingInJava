package com.likai.chapter11.practice;

import java.util.Iterator;

/**
 * Created by likai on 2018/10/21.
 */
public class Test9 implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String [] args) {
        Test9 t = new Test9() ;
        for (String s : t) {

        }
    }
}
