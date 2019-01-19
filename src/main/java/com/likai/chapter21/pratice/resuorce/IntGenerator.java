package com.likai.chapter21.pratice.resuorce;

public abstract class IntGenerator {
    private volatile boolean canceled = false ;
    public abstract int next() ;
    public void cancel() {
        this.canceled = true ;
    }
    public boolean isCanceled() {
        return this.canceled ;
    }
}
