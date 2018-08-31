package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */

interface Selector {
    public boolean end() ;
    public Object current() ;
    public void next() ;
}
public class Sequence {
    private Object [] items ;
    private int next ;
    public Sequence(int size) {
        this.items = new Object [size] ;
    }

    public void add(Object x) {
        if(next < items.length) {
            items[next ++] = x ;
        }
    }

    private class SequenceSelector implements  Selector {

        private int i ;

        @Override
        public boolean end() {
            return i == items.length ;
        }

        @Override
        public Object current() {
            return items[i] ;
        }

        @Override
        public void next() {
            if(this.i < items.length) {
                this.i ++ ;
            }
        }
    }

    private class ReverseSelector implements Selector {
        private int i ;
        @Override
        public boolean end() {
            return i == items.length ;
        }

        @Override
        public Object current() {
            return items[items.length - (i + 1)];
        }

        @Override
        public void next() {
            if(this.i < items.length) {
                this.i ++ ;
            }
        }
    }
    public Selector reverseSelector() {
        return new ReverseSelector() ;
    }

    public Selector selector() {
        return new SequenceSelector() ;
    }

    public static void main(String [] args) {
        Sequence sequence = new Sequence(10) ;
        for(int i = 0 ; i < 10; i ++) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector() ;

        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        Selector selector1 = sequence.reverseSelector() ;
        while (!selector1.end()) {
            System.out.println(selector1.current());
            selector1.next();
        }

    }
}
