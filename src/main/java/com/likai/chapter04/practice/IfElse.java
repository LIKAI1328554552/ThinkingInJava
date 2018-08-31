package com.likai.chapter04.practice;

/**
 * Created by likai on 2018/08/05.
 */
public class IfElse {

    public static int test(int testval ,int target, int begin, int end) {
        if(begin <= testval && testval <= end) {
            if(testval > target) {
                return 1 ;
            } else if(testval < target) {
                return -1 ;
            } else {
                return 0 ;
            }
        } else {
            return 2 ;
        }
    }

    public static void main(String [] args) {
        System.out.println(test(11,10,1,5));
    }

}
