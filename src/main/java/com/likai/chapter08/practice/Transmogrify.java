package com.likai.chapter08.practice;

import javafx.scene.control.Alert;

/**
 * Created by likai on 2018/08/17.
 */

class AlertStatus {
    public void alert() {

    }
}

class NormalAlert extends AlertStatus {
    public void alert() {
        System.out.println("NormalAlert.alert()");
    }
}

class HighAlert extends AlertStatus {
    public void alert() {
        System.out.println("HighAlert.alert()");
    }
}

class MaximumAlert extends AlertStatus {
    public void alert() {
        System.out.println("MaximumAlert.alert()");
    }
}
public class Transmogrify {
    private AlertStatus status = new AlertStatus() ;

    public void changNormal () {
        this.status = new NormalAlert() ;
    }

    public void changHigh () {
        this.status = new HighAlert() ;
    }
    public void changMax () {
        this.status = new MaximumAlert() ;
    }

    public void performPlay() {
        this.status.alert();
    }
    public static void main(String [] args) {
        Transmogrify t = new Transmogrify() ;
        t.performPlay();
        t.changNormal();
        t.performPlay();
        t.changHigh();
        t.performPlay();
        t.changMax();
        t.performPlay();
    }

}
