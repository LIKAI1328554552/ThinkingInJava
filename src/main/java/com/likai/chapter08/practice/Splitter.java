package com.likai.chapter08.practice;

import java.util.Arrays;

/**
 * Created by likai on 2018/08/22.
 */
public class Splitter implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" ")) ;
    }
}
