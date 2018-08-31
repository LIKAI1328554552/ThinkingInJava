package com.likai.chapter09;

/**
 * Created by likai on 2018/08/28.
 */
public abstract class Event {
    private long eventTime ;
    protected final long delayTime ;
    public Event(long delayTime) {
        this.delayTime = delayTime ;
        start() ;
    }

    public void start() {
        this.eventTime = System.nanoTime() + this.delayTime ;
    }

    public boolean ready() {
        return System.nanoTime() >= this.eventTime ;
    }

    public abstract void action() ;


}
