package com.likai.data_structure.tree;

public class Tree {
    public Node root ;

    public Tree() {
        super();
    }

    public void insert(int data) {
        //当根节点为null时 插入一个根节点
        if(this.root  == null) {
            this.root = new Node(data) ;
            return ;
        }
        //当前节点
        Node current = this.root ;
        //是否在左边的标志
        boolean isLeft = true ;
        //父节点
        Node parent = this.root ;

        while (current != null) {
            parent = current ;
            //如果data小于当前节点的值
            if (data < current.data) {
                //那么进入左子树
                current = current.leftChildren ;
                isLeft = true ;
            } else {
                //那么进入右子树
                current = current.rightChildren ;
                isLeft = false ;
            }
        }

        if (isLeft) {
            parent.leftChildren = new Node(data) ;
        } else {
            parent.rightChildren = new Node(data) ;
        }
    }

    public Node find(int data) {
        if (this.root == null) {
            return null ;
        }

        Node current = this.root ;
        while (data != current.data) {
            if (data < current.data) {
                //进入左子树
                current = current.leftChildren ;
            } else {
                //进入右子树
                current = current.rightChildren ;
            }

            //表示当前节点已经是根节点的子节点了
            if (current == null) {
                return null ;
            }
        }

        return current ;
    }

    public void frontOrder(Node node) {
        if (node == null) {
            return ;
        }

        //1先输出中节点
        node.display();
        //2先序遍历左子树
        frontOrder(node.leftChildren);
        //3先序遍历右子树
        frontOrder(node.rightChildren);
    }

    public void midOrder(Node node) {
        if (node == null) {
            return ;
        }
        //1中序遍历左子树
        midOrder(node.leftChildren);
        //2输出中节点
        node.display();
        //3中序遍历右子树
        midOrder(node.rightChildren);
    }

    public void afterOrde(Node node) {
        if (node == null) {
            return ;
        }
        //1后序遍历左子树
        afterOrde(node.leftChildren);
        //2后序遍历右子树
        afterOrde(node.rightChildren);
        //3输出中节点
        node.display();
    }


    public static void main(String [] args) {
        Tree tree = new Tree() ;
        tree.insert(50);
        tree.insert(45);
        tree.insert(40);
        tree.insert(49);

        tree.insert(89);
        tree.insert(79);
        tree.insert(109);
        tree.insert(69);

        System.out.println();


        System.out.println(tree.find(45));

        tree.frontOrder(tree.root);
        System.out.println();
        tree.midOrder(tree.root);
        System.out.println();
        tree.afterOrde(tree.root);

    }

}
