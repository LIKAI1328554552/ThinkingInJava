package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class Parcel5 {
    public Destination destination(String s) {

        class PDestination implements Destination {
            private String label ;
            private PDestination(String label) {
                this.label = label ;
            }
            @Override
            public String readLabel() {
                return this.label;
            }
        }

        return new PDestination(s) ;
    }

    public static void main(String [] args) {
        Parcel5 p = new Parcel5() ;
        Destination d = p.destination("Hello World") ;
        System.out.println(d.readLabel()) ;
    }
}
