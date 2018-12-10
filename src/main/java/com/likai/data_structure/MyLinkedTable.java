package com.likai.data_structure;

import com.likai.chapter09.GreenhouseController;

/**
 * 节点
 */
class Node {
    /**
     * 节点的数据
     */
    int data ;

    /**
     * 下一个节点的地址
     */
    Node next ;

    public Node(int data) {
        this.data = data ;
    }

    public void display() {
        System.out.println(this.data + ",");
    }

}

/**
 * 链表
 */
public class MyLinkedTable {

    private Node first ;

    public MyLinkedTable() {
        super();
    }

    public void addFirst(int data) {
        //链表中没有数据时
        if(this.first == null) {
            //新建一个节点 让first指向它
            this.first = new Node(data) ;
            return ;
        } else {
            //1.新建一个节点
            Node node = new Node(data) ;
            //2.将此节点下一个节点指向first
            node.next = this.first ;
            //3.将first节点指向此节点
            this.first = node ;
        }
    }

    public Node removeFirst() {
        if(this.first == null) {
            return null ;
        } else {
            Node resultNode = this.first ;
            this.first = this.first.next ;
            return resultNode ;
        }
    }

    public void addLast(int data) {
        //链表中没有数据时
        if(this.first == null) {
            this.first = new Node(data) ;
            return ;
        } else {
            //遍历到链表结尾
            Node currentNode = this.first ;
            //如果下一个节点不为空 继续往下走
            while (currentNode.next != null) {
                currentNode = currentNode.next ;
            }
            //遍历完成之后说明currentNode为最后一个节点
            currentNode.next = new Node(data) ;
        }
    }

    public Node removeLast() {
        if(this.first == null) {
            //一个节点也没有时
            return null ;
        } else if (this.first.next == null) {
            //仅有一个节点时
            Node resultNode = this.first ;
            this.first = null ;
            return resultNode ;
        } else {
            //多个节点时
            Node curentNode = this.first ;
            //当前节点的前一个节点
            Node previousNode = null;
            while(curentNode.next != null) {
                previousNode = curentNode ;
                curentNode = curentNode.next ;
            }
            //遍历到currentNode为最后一个节点 让前一个的next指向null
            previousNode.next = null ;
            return curentNode ;
        }
    }

    public void display() {
        //当前节点 从first节点开始
        Node currentNode = this.first ;

        while(currentNode != null) {
            currentNode.display();
            currentNode = currentNode.next ;
        }

    }

    /**根据值 查找节点
     * @param data
     * @return
     */
    public Node get(int data) {
        //一个节点都没有时
        if(this.first == null) {
            return null ;
        }
        Node currentNode = this.first ;
        //当值不相等是 继续往下遍历链表
        while(currentNode.data != data) {
            currentNode = currentNode.next ;
            //此时说明此链表中都没有值为data的节点
            //(此时已经指向下一个节点 因此判断当前节点)
            if(currentNode == null) {
                return null ;
            }
        }

        return currentNode ;
    }

    /**
     * 根据值进行删除
     * @param data
     * @return
     */
    public Node remove(int data) {
        //一个节点都没有时
        if(this.first == null) {
            return null ;
        }

        //多个节点时
        Node previousNode = null ;
        Node currentNode = this.first ;
        while (currentNode.data != data) {
            previousNode = currentNode ;
            currentNode = currentNode.next ;
            //此时说明此链表中都没有值为data的节点
            if(currentNode == null) {
                return null ;
            }
        }

        //如果代码走到这里 有两个情况 1: 没有走循环(第一个节点就匹配上了) 2:在循环中找到了节点
        if(this.first.data == data) {
            Node reusltNode = this.first ;
            this.first = this.first.next ;
            return reusltNode ;
        } else {
            previousNode.next = currentNode.next ;
        }

        return currentNode ;
    }

    public static void main(String [] args) {
        MyLinkedTable linked = new MyLinkedTable() ;
        linked.addFirst(1);
        linked.addFirst(2);
        linked.addFirst(3);
        linked.addFirst(4);
        linked.addFirst(5);

        /*linked.display();

        System.out.println("-------------");

        System.out.println(linked.removeFirst().data) ;

        linked.display();

        System.out.println("-------------");

        linked.addLast(55);

        linked.display();

        System.out.println("-------------");

        System.out.println(linked.removeLast().data);

        linked.display();

        System.out.println(linked.get(1).data);*/

        System.out.println(linked.remove(4).data);
        linked.display();

        System.out.println(linked.remove(4).data);
        linked.display();

        System.out.println(linked.remove(4).data);
        linked.display();
    }
}
