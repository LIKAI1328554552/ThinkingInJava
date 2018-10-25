package com.likai.chapter11.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by likai on 2018/10/21.
 */
public class Test4 {
    public static void main(String[] args) {
        List<Integer> li1 =
                new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> li2 =
                new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
        ListIterator<Integer> it1 = li1.listIterator();
        ListIterator<Integer> it2 = li2.listIterator();
        System.out.println("li1: " + li1);
        System.out.println("li2: " + li2);
        // move it1 to end:
        while(it1.hasNext())
            it1.next();
        // now use it2 to re-set li2:
        while(it2.hasNext()) {
            it2.next();
            it2.set(it1.previous());
        }
        System.out.println("li1: " + li1);
        System.out.println("li2: " + li2);

    }
}
