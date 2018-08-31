package com.likai.chapter08.practice;

/**
 * Created by likai on 2018/08/22.
 */

class Waveform {
    private static long counter ;
    private final long id = counter ++;
    public String toString() {
        return "Waveform  " + this.id ;
    }
}
class Filter {
    public String name() {
        return getClass().getSimpleName() ;
    }

    public Waveform process(Waveform waveform) {
        return waveform ;
    }
}

class LowPass extends Filter {
    public double cutoff ;
    public LowPass(double cutoff) {
        this.cutoff = cutoff ;
    }

    public Waveform process(Waveform waveform) {
        return waveform ;
    }
}

class HighPass extends Filter {
    public double cutoff ;
    public HighPass(double cutoff) {
        this.cutoff = cutoff ;
    }

    public Waveform process(Waveform waveform) {
        return waveform ;
    }
}

public class BandPass extends Filter{
    public double lowCutoff ;
    public double highCutoff ;
    public BandPass(double lowCutoff,double highCutoff) {
        this.lowCutoff = lowCutoff ;
        this.highCutoff = highCutoff ;
    }

    public Waveform process(Waveform waveform) {
        return waveform ;
    }
}
