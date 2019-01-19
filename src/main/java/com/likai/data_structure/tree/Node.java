package com.likai.data_structure.tree;

public class Node {
    public int data ;

    public Node leftChildren ;
    public Node rightChildren ;

    public Node(int data) {
        this.data = data ;
    }

    public void display() {
        System.out.print(this.data + " ,");
    }
}
