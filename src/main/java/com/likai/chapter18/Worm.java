package com.likai.chapter18;

import java.io.*;
import java.util.Random;

class Data implements Serializable {
    private int n ;
    public Data(int n) {
        this.n = n ;
    }

    @Override
    public String toString() {
        return Integer.toString(this.n);
    }
}
public class Worm implements Serializable{
    private static Random rand = new Random(47) ;
    private Data [] datas = {
       new Data(rand.nextInt(10)),
       new Data(rand.nextInt(10)),
       new Data(rand.nextInt(10))
    } ;

    private Worm next ;
    private char c ;
    public Worm() {
        System.out.println("Default constructor");
    }
    public Worm(int i,char x) {
        System.out.println("Worm constructor : " + i);
        this.c = x ;
        if(-- i > 0) {
            next = new Worm(i,(char) (x + 1)) ;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":") ;
        result.append(this.c) ;
        result.append("(") ;
        for (Data data : datas) {
            result.append(data) ;
        }
        result.append(")") ;
        if(this.next != null) {
            result.append(this.next) ;
        }

        return result.toString() ;
    }
    public static void main(String [] args) throws Exception {
        Worm w = new Worm(6,'a') ;
        System.out.println("w = " + w);
        //输出
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/worm.out")) ;
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();
        //写入
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/worm.out")) ;
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println("w2 = " + w2);
        in.close();

        //
        ByteArrayOutputStream bout = new ByteArrayOutputStream() ;
        ObjectOutputStream out2 = new ObjectOutputStream(bout) ;
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();

        //
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray())) ;
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println("w3 = " + w3);

    }

}
