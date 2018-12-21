package com.likai.data_structure;

/**
 * 双端链表
 */
public class DoubleEndedLinkedTable {

    //头节点
    private Node first ;

    //尾节点
    private Node last ;

    public void addFirst(int data) {
        Node node = new Node(data) ;
        //链表为空时 头尾节点全都指向它
        if(this.first == null) {
            this.first = node ;
            this.last = node ;
            return ;
        }
        //链表不为空时
        //让node的下一个节点指向头节点 再让头结点指向node
        node.next = this.first ;
        this.first = node ;
    }

    public void addLast(int data) {
        Node node = new Node(data) ;
        if(this.first == null) {
            this.first = node ;
            this.last = node ;
            return ;
        }
        //链表不为空时
        //让尾节点的下一个节点指向node 再让尾节点指向node
        this.last.next = node ;
        this.last = node ;

    }

    public Node removeFirst() {
        //没有节点时
        if(this.first == null) {

            return null ;
        }
        //仅有一个节点时
        if(this.first.next == null) {
            Node resultNode = this.first ;
            this.first = null ;
            this.last = null ;

            return resultNode ;
        }

        //有多个节点时
        Node resultNode = this.first ;
        this.first = this.first.next ;
        return resultNode ;
    }

    public Node removeLast() {
        //没有节点时
        if(this.first == null) {
            return null ;
        }
        //仅有一个节点时
        if(this.first.next == null) {
            Node resultNode = this.first ;

            this.first = null ;
            this.last = null ;

            return resultNode ;
        }

        //多个节点时
        Node currentNode = this.first ;
        //循环取得倒数第二个节点
        while (currentNode.next != this.last) {
            currentNode = currentNode.next ;
        }
        //记录结果
        Node resultNode = this.last ;
        //将倒数第二节点的下一个节点置空
        currentNode.next = null ;
        //将尾节点指向currentNode
        this.last = currentNode ;

        return resultNode ;

    }

    public Node remove(int data) {
        //不存在节点时
        if(this.first == null) {
            return null ;
        }

        //仅有一个节点时
        if(this.first.next == null) {
            if(this.first.data == data) {
                Node current = this.first ;
                this.first = null ;
                this.last = null ;
                return current ;
            } else {
                return null ;
            }
        }


        //当有多个节点时
        Node current = this.first ;
        Node previous = null ;
        while (current.data != data) {
            previous = current ;
            current = current.next ;
            if(current == null) {
                return null ;
            }
        }

        if(this.first.data == data) {
            //1.第一个节点值域 = data时
            this.first = current.next ;
            return current ;
        } else if(this.last.data == data) {
            //2.最后一个节点值域 == data
            //这一步是必须的 因为如果previous的下一个节点不清空 那么 previous.next 还是指向current的 这就没有删除节点了
            previous.next = null ;
            //将last指针指向previous
            this.last = previous ;
            return current ;
        } else {
            //处于中间时
            previous.next = current.next ;
            return current ;
        }

    }

    public Node get(int data) {
        //一个节点也没有
        if(this.first == null) {
            return null ;
        }

        //一个多个节点节点时
        Node current = this.first ;
        while (current.data != data) {
            current = current.next ;

            if(current == null) {
                return null ;
            }
        }
        if(this.first.data == data) {
            return this.first ;
        } else if(this.last.data == data) {
            return this.last ;
        } else {
            return current ;
        }


    }

    public void display() {
        Node current = this.first ;
        while(current != null) {
            current.display();
            current = current.next ;
        }
    }

    public static void main(String [] args) {
        DoubleEndedLinkedTable del = new DoubleEndedLinkedTable() ;
        del.addFirst(1);
        del.addFirst(2);
        del.addFirst(3);
        del.addFirst(4);

        del.addLast(10);
        del.addLast(11);
        del.addLast(12);

        del.display();

        System.out.println("---------------------");

        System.out.println(del.removeFirst().data);

        del.display();

        System.out.println("---------------------");

        System.out.println(del.removeLast().data) ;

        del.display();
        System.out.println("---------------------");

        System.out.println(del.remove(3).data);

        del.display();

        System.out.println("---------------------");

        System.out.println(del.remove(11).data);

        del.display();

        System.out.println(del.get(1).data);
    }

}
