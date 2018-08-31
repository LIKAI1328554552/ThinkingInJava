package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/12.
 */
public class Orc extends Villain {
    private int orcNumber ;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber ;
    }

    public void change(String name, int orcNumber) {
        setName(name);
        this.orcNumber = orcNumber ;
    }

    public String toString() {
        return "Orc number:" + this.orcNumber ;
    }

    public static void main(String [] args) {
        Orc orc = new Orc("likai",47) ;
        System.out.println(orc);
        orc.change("lixinyi",22);
        System.out.println(orc);
    }
}
