package com.likai.data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by likai on 2018/11/20.
 * 循环使用
 */
public class MyQueue {

    private int [] array ;

    private int size ;

    //队头
    private int start ;

    //队尾
    private int end ;

    public MyQueue() {
        this.array = new int[50] ;
        this.size = 0 ;
        this.start = 0 ;
        this.end = - 1 ;
    }

    public MyQueue(int size) {
        this.array = new int[size] ;
        this.size = 0 ;
        this.start = 0 ;
        this.end = - 1 ;
    }

    /**
     * 插入队伍 从队尾
     * @param value
     */
    public void insert(int value) {

        if(this.end == this.array.length -1) {
            this.end = -1 ;
        }

        this.array[++ this.end] = value ;
        this.size ++ ;
    }

    /**
     * 出队 从队头
     * @return
     */
    public int remove() {
        int value = this.array[this.start ++] ;
        if(this.start == this.array.length) {
            this.start = 0 ;
        }
        this.size -- ;
        return value;
    }

    /**
     * 判断队伍是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0 ;
    }

    /**
     * 判断队伍是否满了
     * @return
     */
    public boolean isFull() {
        return this.size == this.array.length ;
    }

    public static void main(String [] args) {
        MyQueue queue = new MyQueue(6);
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        System.out.println(queue.remove()); ;
        queue.insert(13);
        queue.insert(14);
        queue.insert(15);
        queue.insert(16);


        while (!queue.isEmpty()) {
            System.out.print(queue.remove());
        }
    }





}
