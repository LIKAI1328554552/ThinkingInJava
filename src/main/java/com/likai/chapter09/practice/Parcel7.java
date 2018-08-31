package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/26.
 */
public class Parcel7 {
    /*public Contents contents() {
        return new Contents() {
            private int value = 11 ;
            @Override
            public int value() {
                return this.value;
            }
        } ;
    }*/

    public Wrapping wrapping(final int x) {
        return new Wrapping() {
            private int i = x ;
            @Override
            public int value() {
                return super.value() * 47;
            }
        } ;
    }

    public static void main(String [] args) {
        Parcel7 p = new Parcel7() ;
        Wrapping wrapping = p.wrapping(11) ;
        System.out.println(wrapping.value());
    }


}
