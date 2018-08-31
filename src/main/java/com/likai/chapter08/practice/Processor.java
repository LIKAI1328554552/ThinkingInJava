package com.likai.chapter08.practice;

import java.util.Random;

/**
 * Created by likai on 2018/08/22.
 */
public interface Processor {

    public static final Random RAND = new Random(47) ;

    public String name();

    public Object process(Object input) ;
}
