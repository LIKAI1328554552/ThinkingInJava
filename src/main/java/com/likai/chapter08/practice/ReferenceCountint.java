package com.likai.chapter08.practice;

/**
 * Created by likai on 2018/08/16.
 */
class Shared {
    private int refcount = 0 ;
    private static long counter = 0 ;
    public final long id = counter ++ ;
    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        this.refcount ++ ;
    }

    protected void dispose() {
        if (-- this.refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    public String toString() {
        return "Shared " + this.id ;
    }
}

class Composing {
    private Shared shared ;
    private int refcount = 0 ;
    private static long counter = 0 ;
    private final long id = counter ++ ;

    public Composing(Shared shared) {
        System.out.println("Composing " + this);
        this.shared = shared ;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        this.shared.dispose();
    }

    public String toString() {
        return "Composing " + this.id ;
    }
}
public class ReferenceCountint {
    public static void main(String [] args) {
        Shared shared = new Shared() ;
        Composing [] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        } ;
        for (Composing composing : composings) {
            composing.dispose();
        }
    }
}
