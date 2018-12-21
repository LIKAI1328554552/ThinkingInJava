package com.likai.data_structure;

/**
 * 节点
 */
public class Node {
    //值域
    int data ;
    //指向下一个节点
    Node next ;

    //指向上一个节点
    Node pre ;

    public Node(int data) {
        this.data = data ;
    }

    public void display() {
        System.out.print(this.data + " ,");
    }
}
