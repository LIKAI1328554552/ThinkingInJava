package com.likai.chapter17.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortedSet {
    private LinkedList<Integer> list ;

    private int size ;

    public SortedSet() {
        super();
        list = new LinkedList<>() ;
        size = 0 ;
    }

    public void add(int value) {
        //找到此元素的位置
        int x = 0 ;
        /*if(this.list.size() == 0) {
            x = 0 ;
        } else {
            for(int i = 0,len = size; i < len ; i ++) {
                if(value < this.list.get(i)) {
                    x = i - 1 ;
                    break ;
                } else {
                    x = i + 1 ;
                }
            }
        }*/
        for(int i = 0 ; i < size; i ++) {
            if(value > this.list.get(i)) {
                x ++ ;
            }
        }
        this.list.add(x,value) ;
        size ++ ;
    }

    public int get(int index) {
        return this.list.get(index) ;
    }

    public int first() {
        return this.list.get(0) ;
    }

    public int last() {
        return this.list.get(this.size - 1) ;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        sb.append("[") ;
        for (Integer integer : list) {
            sb.append(integer + " ") ;
        }

        sb.append("]") ;
        return sb.toString() ;
    }

    public static void main(String [] args) {
        SortedSet sortedSet = new SortedSet() ;
        sortedSet.add(5);
        sortedSet.add(3);
        sortedSet.add(19);

        System.out.println(sortedSet);

        System.out.println(sortedSet.first());

        System.out.println(sortedSet.last());

    }

}

