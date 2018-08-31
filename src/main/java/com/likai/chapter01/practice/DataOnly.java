package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/02.
 */
public class DataOnly {
    private int i ;
    private double d ;
    private boolean b ;

    public DataOnly() {
        super();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "DataOnly{" +
                "i=" + i +
                ", d=" + d +
                ", b=" + b +
                '}';
    }

    public static void main(String [] args) {
        DataOnly data = new DataOnly() ;
        data.setI(1);
        data.setD(1.1);
        data.setB(true);
        System.out.println(data.toString());
    }
}
