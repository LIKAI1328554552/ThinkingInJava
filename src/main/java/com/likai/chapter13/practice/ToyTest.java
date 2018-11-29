package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/10/28.
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Test {}

class Toy {
    public Toy() {
        super() ;
    }
    public Toy(int i) {
        super();
    }
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String [] args) {
        Class c = null ;
        try {
            c = Class.forName("com.likai.chapter13.practice.FancyToy") ;
        } catch (ClassNotFoundException e) {
            System.out.println("Don't find FancyToy");
            System.exit(0);
        }
        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass() ;
        Object obj = null ;

        try {
            obj = up.newInstance() ;
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(0);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(0);
        }

        printInfo(obj.getClass());
    }
}
