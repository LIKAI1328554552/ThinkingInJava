package com.likai.chapter13.practice;

/**
 * Created by likai on 2018/10/28.
 */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}
class Gum {
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String [] args) {
        if(args.length < 1) {
            System.out.println("异常");
            System.exit(0);
        }
        Class c = null ;
        try {
            c= Class.forName(args[0]) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
