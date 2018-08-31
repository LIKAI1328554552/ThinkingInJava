package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/24.
 */
public class Test2 {
    public static void main(String [] args) {
        TestParcel parcel = new TestParcel() ;
        Contents contents = parcel.contents() ;
        Destination destination = parcel.destination() ;

        /*TestParcel.PDestination pDestination = parcel.new PDestination("s") ;
        TestParcel.PContents pContents = parcel.new PContents() ;*/
    }
}
