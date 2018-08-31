package com.likai.chapter09.practice;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by likai on 2018/08/24.
 */
class TestParcel {
    private class PContents implements Contents {
        private int i = 11 ;
        @Override
        public int value() {
            return this.i;
        }
    }

    protected class PDestination implements Destination {
        private String label ;

        private PDestination(String label) {
            this.label = label ;
        }
        @Override
        public String readLabel() {
            return this.label;
        }
    }

    public Destination destination() {
        return new PDestination("Hello World") ;
    }

    public Contents contents() {
        return new PContents() ;
    }

    public static void main(String [] args) {
        TestParcel parcel = new TestParcel() ;
        Contents contents = parcel.contents() ;
        Destination destination = parcel.destination() ;

        PDestination pDestination = parcel.new PDestination("s") ;
        PContents pContents = parcel.new PContents() ;


    }
}
