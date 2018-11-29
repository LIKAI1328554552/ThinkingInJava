package com.likai.chapter16.practice;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by likai on 2018/11/11.
 */
class IceCream {
    private Random rand = new Random(47) ;
    private String [] flavors = {
       "Chocolate Fudge Brownie","Cookie Dough","Phish Food",
        "Strawberry Cheesecake","Cherry Garcia","Chunky Monkey"
    } ;

    public String [] flavorSet(int n) {
        if(n < 0 || n > this.flavors.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String [] result = new String[n] ;
        //用于记录flavors数组中已经选过的口味
        boolean [] picked = new boolean[this.flavors.length] ;

        for(int i = 0 ; i < n; i ++) {
            int t = 0 ;
            //找到口味没有被选过的索引
            do {
                t = this.rand.nextInt(this.flavors.length) ;
            } while (picked[t]) ;

            result[i] = this.flavors[t] ;
            picked[t] = true ;

        }
        return result ;
    }
}
public class Test3 {
    public static void main(String [] args) {
        IceCream cream = new IceCream() ;

        System.out.println(Arrays.toString(cream.flavorSet(4)));
    }
}
