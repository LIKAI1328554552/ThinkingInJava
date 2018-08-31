package com.likai.chapter09;

/**
 * 内部类应用
 * Created by likai on 2018/08/28.
 */
public class Test1 {
    public static void main(String [] args) {
        GreenhouseController gc = new GreenhouseController() ;
        gc.addEvent(gc.new Bell(900));
        Event [] events = {
           gc.new ThermostatDay(0),
           gc.new LightOn(200),
           gc.new LightOff(400),
           gc.new WaterOn(600),
           gc.new WaterOff(800),
           gc.new ThermostatDay(1400)
        } ;

        gc.addEvent(gc.new Restart(2000,events));
        if(args.length == 1) {
            gc.addEvent(new GreenhouseController.Terminate(new Integer(args[0])));
        }

        gc.run();
    }
}
