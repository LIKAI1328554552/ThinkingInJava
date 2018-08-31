package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class Parcel1 {
    class Contents {
        private int i = 11 ;
        public int value() {
            return this.i ;
        }
    }

    class Destination {
        private String label ;

        Destination(String whereTo) {
            this.label = whereTo ;
        }

        String readLabel() {
            return this.label ;
        }
    }

    public Destination to(String s) {
        return new Destination(s) ;
    }

    public Contents contents() {
        return new Contents() ;
    }

    public void ship(String dest) {
        Contents c = new Contents() ;
        Destination d = new Destination(dest) ;

        System.out.println(d.readLabel());
    }

    public static void main(String [] args) {
        Parcel1 p = new Parcel1() ;
        p.ship("Hello World!") ;

        Contents c = p.contents() ;
        Destination d = p.to("Hello World 2") ;

        Outer outer = new Outer() ;
        Outer.Inner inner = outer.inner() ;
    }

}
