package com.likai.chapter16.practice;

import java.util.Arrays;

/**
 * Created by likai on 2018/11/11.
 */
public class Test1 {
    public static void test(BerylliumSphere[] a) {
        System.out.println(Arrays.asList(a));
    }
    // Generic version:
    public static <T> void test(T[] t) {
        System.out.println(Arrays.asList(t));
    }
    // int version:
    public static void test(int[] ia) {
        System.out.println(Arrays.toString(ia));
    }


    public static void main(String[] args) {
        System.out.println("For objects, e.g., BerylliumSpheres:");
        // Array is created and initialized (aggregate initialization)
        // but all elements are null, not BerylliumSpheres:
        test(new BerylliumSphere[3]);
        // Dynamic aggregate initialization works;
        // elements are now BerylliumSpheres:
        test(new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere() });
        // Aggregate initialization this way works:
        BerylliumSphere[] a = { new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere() };
        test(a);
        // Elements initialized to null:
        BerylliumSphere[] bsa = new BerylliumSphere[2];
        test(bsa);
        bsa = a;
        test(bsa);
        System.out.println("-------------");
        System.out.println("For primitives, e.g., int:");
        // Dynamic aggregate initialization works:
        test(new int[]{ new Integer(0), new Integer(0) });
        // But may be considered redundant, since
        // aggregate initialization works:
        // elements initialized to zero (not null):
        test(new int[2]);
        // Ordinary aggregate initialization this way also works:
        int[] ia = { 1, 2, 3, };
        test(ia);
    }
}
