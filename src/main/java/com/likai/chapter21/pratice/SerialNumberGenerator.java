package com.likai.chapter21.pratice;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0 ;
    public static synchronized int nextSerialNumber() {
        return serialNumber ++;
    }
}
