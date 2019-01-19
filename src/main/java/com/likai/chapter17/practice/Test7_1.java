package com.likai.chapter17.practice;

import java.util.AbstractSet;
import java.util.Iterator;

public class Test7_1 {
    private MySet<String> list = new MySet<String>() ;

    private String get(int i) {
        return "ceshi";
    }

    public void add(String data) {
        list.add(data) ;
    }


    private class MySet<String> extends AbstractSet<String> {
        private int index = 0 ;
        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return index < list.size() - 1;
                }

                @Override
                public String next() {
                    return (String) "next()";
                }

                @Override
                public void remove() {
                    System.out.println("remove");
                }
            };
        }

        @Override
        public int size() {
            return 0;
        }
    }

    public static void main(String [] args) {
        Test7_1 t = new Test7_1() ;
        t.add("1");
        t.add("2");
        t.add("3");
    }
}
