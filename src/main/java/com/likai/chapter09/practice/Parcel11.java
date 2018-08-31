package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/27.
 */
public class Parcel11 {

    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return this.i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        public static class AnotherLevel {
            public static void f() {

            }

            static int x = 10 ;
        }
        private ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return this.label;
        }

        private void f() {

        }
    }

    public static Destination destination(String s) {
        new ParcelDestination(s).f() ;
        return new ParcelDestination(s) ;
    }

    public static Contents contents() {
        return new ParcelContents() ;
    }

    public static void main(String [] args) {
        Contents c = Parcel11.contents() ;
        Destination s = Parcel11.destination("Hello World!") ;
    }
}
