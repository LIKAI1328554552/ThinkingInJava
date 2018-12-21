package com.likai.data_structure;

public class TwoWayLinkedTable {

    private Node first ;

    private Node last ;

    public void addFirst(int data) {
        Node node = new Node(data) ;
        //没有节点时
        if(this.first == null) {
            this.first = node ;
            this.last = node ;
            return ;
        } else {
            //有节点时
            //当前节点的下一个节点指向first
            node.next = this.first ;
            //first节点的上一个节点指向当前节点
            this.first.pre = node ;
            //first节点指向当前节点
            this.first = node ;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data) ;
        if(this.first == null) {
            this.first = node ;
            this.last = node ;
            return ;
        } else {
            //last节点的下一个节点指向当前节点
            this.last.next = node ;
            //当前节点的上个节点指向last节点
            node.pre = this.last ;
            //last节点指向当前节点
            this.last = node ;

        }
    }

    public Node removeFirst() {
        //没有节点时
        if(this.first == null) {
            return null ;
        }

        //仅有一个节点时
        if(this.first.next == null) {
            Node result = this.first ;
            this.first = null ;
            this.last = null ;
            return result ;
        }

        //多个节点时
        Node result = this.first ;
        this.first = this.first.next ;
        this.first.pre = null ;
        return result ;
    }

    public Node removeLast() {
        //没有节点时
        if(this.first == null) {
            return null ;
        }

        //仅有一个节点时
        if(this.first.next == null) {
            Node result = this.first ;
            this.first = null ;
            this.last = null ;
            return result ;
        }

        //如果有多个节点时
        Node result = this.last ;
        this.last = this.last.pre ;
        this.last.next = null ;
        return result ;

    }

    public void display() {
        Node current = this.first ;
        while (current != null) {
            current.display();
            current = current.next ;
        }

        System.out.println();
    }

    public static void main(String [] args) {
        TwoWayLinkedTable twl = new TwoWayLinkedTable() ;
        twl.addFirst(1);
        twl.addFirst(2);
        twl.addFirst(3);
        twl.addFirst(4);
        twl.addFirst(5);
        twl.addLast(11);
        twl.addLast(22);
        twl.addLast(33);

        twl.removeFirst() ;
        twl.removeFirst() ;
        twl.removeLast() ;
        twl.removeLast() ;

        twl.display();
    }

}
