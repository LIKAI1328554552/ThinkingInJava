package com.likai.recursive;

public class Recursive {

    //三角函数
    // 行号:  1  2  3  4  5     ...n
    // 内容:  1  3  6  10 15    ...f(n-1) + n

    public static void main(String [] args) {
        System.out.println(f(40));
    }

    public static int f(int n) {
        if(n == 1) {
            return 1 ;
        } else {
            return f(n - 1) + n ;
        }
    }
}
