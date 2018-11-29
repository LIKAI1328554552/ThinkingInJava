package com.likai.chapter16.practice;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by likai on 2018/11/11.
 */
public class CompType implements Comparable<CompType> {

    int i ;
    int j ;

    private static int count = 1 ;

    public CompType(int i,int j) {
        this.i = i ;
        this.j = j ;
    }

    public String toString() {
        String result = "[i="+i+",j="+j+"]" ;
        if(count ++ % 3 == 0) {
            result += "\n" ;
        }

        return result ;
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 :(i == o.i ? 0 : 1));
    }

    private static Random rand = new Random(47) ;

    public static void main(String [] args) {
        CompType [] array = {
                new CompType(44,5),new CompType(24,6),new CompType(47,5),
                new CompType(33,5),new CompType(43,8),new CompType(7,5),
                new CompType(9876,5),new CompType(5,5),new CompType(90,5)
        } ;
        System.out.println(Arrays.deepToString(array));
        Arrays.sort(array);
        System.out.println(Arrays.deepToString(array));
        int result = Arrays.binarySearch(array,new CompType(44,5)) ;
        System.out.println(result);
    }
}
