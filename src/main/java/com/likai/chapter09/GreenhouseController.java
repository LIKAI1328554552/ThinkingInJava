package com.likai.chapter09;

/**
 * Created by likai on 2018/08/28.
 */
public class GreenhouseController extends Controller {
    private boolean light = false ;
    private boolean water = false ;
    private String thermostat = "Day" ;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true ;
        }

        public String toString() {
            return "Light is on" ;
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false ;
        }

        public String toString() {
            return "Light is off" ;
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true ;
        }

        public String toString() {
            return "Water is on" ;
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false ;
        }

        public String toString() {
            return "Water is off" ;
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            thermostat = "Night" ;
        }

        public String toString() {
            return "Thermostat is night" ;
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            thermostat = "Day" ;
        }

        public String toString() {
            return "Thermostat is day" ;
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        public String toString() {
            return "Bing" ;
        }
    }

    public class Restart extends Event {
        private Event [] events ;
        public Restart(long delayTime,Event [] events) {
            super(delayTime) ;
            this.events = events ;
            for (Event event : events) {
                addEvent(event);
            }
        }
        @Override
        public void action() {
            for (Event event : events) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        public String toString() {
            return "Restartint System" ;
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.exit(0) ;
        }

        public String toString() {
            return "Terminating" ;
        }
    }

}
