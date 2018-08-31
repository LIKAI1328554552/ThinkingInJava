package com.likai.chapter05.practice;

/**
 * Created by likai on 2018/08/05.
 */
public class WebBank {
    private boolean loggedIn = false ;
    public WebBank() {
        super();
    }
    public WebBank(boolean logStatus) {
        this.loggedIn = logStatus ;
    }

    public void logIn() {
        this.loggedIn = true ;
    }

    public void logOut() {
        this.loggedIn = false ;
    }

    @Override
    protected void finalize() throws Throwable {
        if(this.loggedIn) {
            System.out.println("Error: still logged in");
        }
    }

    public static void main(String [] args) {
        WebBank w1 = new WebBank(true) ;
        w1.logOut();
        WebBank w2 = new WebBank(true) ;
        w2.logOut();
        WebBank w3 = new WebBank(true) ;
        System.out.println("Try 1: ");
        System.runFinalization();
        System.out.println("Try 2: ");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
        System.gc();

    }
}

