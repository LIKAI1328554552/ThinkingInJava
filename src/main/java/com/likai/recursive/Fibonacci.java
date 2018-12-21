package com.likai.recursive;

public class Fibonacci {
    //序号: 1   2   3   4   5   6     ...n
    //内容: 0   1   1   2   3   5     ...f(n-1) + f(n-2)

    public static int f(int n) {
        if(n == 1) {
            return 0 ;
        } else if(n == 2) {
            return 1 ;
        } else {
            return f(n-1) + f(n - 2) ;
        }
    }


    public static void main(String [] args) {
        System.out.println(Fibonacci.f(6));
    }
}
