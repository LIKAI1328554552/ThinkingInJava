package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/02.
 */
public class AllTheColorsOfRainbow {
    public int anIntegerRepresentingColors ;

    public void ChangeTheHueOfTheColor(int newHue) {
        this.anIntegerRepresentingColors = newHue ;
    }

    public static void main(String [] args) {
        AllTheColorsOfRainbow a = new AllTheColorsOfRainbow() ;
        System.out.println(a.anIntegerRepresentingColors);
        a.ChangeTheHueOfTheColor(10);
        System.out.println(a.anIntegerRepresentingColors);
    }
}
