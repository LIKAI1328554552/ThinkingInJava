package com.likai.chapter08.practice;


/**
 * Created by likai on 2018/08/22.
 */
public class Downcase implements Processor {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase() ;
    }
}
