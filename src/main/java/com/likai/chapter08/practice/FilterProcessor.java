package com.likai.chapter08.practice;

/**
 * Created by likai on 2018/08/22.
 */
class FilterAdapter implements Processor {
    public Filter filter ;

    public FilterAdapter(Filter filter) {
        this.filter = filter ;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
public class FilterProcessor {
    public static void main(String [] args) {
        Waveform waveform = new Waveform() ;
        Apply.process(new FilterAdapter(new LowPass(1.0)),waveform);

    }
}
