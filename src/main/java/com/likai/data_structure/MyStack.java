package com.likai.data_structure;

/**
 * Created by likai on 2018/11/18.
 * 自定义栈
 */
public class MyStack {
    //数组
    private int [] arr ;
    //栈顶位置
    private int top ;

    public MyStack() {
        this.arr = new int[50] ;
        this.top = - 1 ;
    }

    public MyStack(int size) {
        this.arr = new int[size] ;
        this.top = - 1 ;
    }

    /**
     * 将数据压入栈
     * @param value
     */
    public void push(int value) {
        this.arr[++ this.top] = value ;
    }

    /**
     * 弹出栈顶数据
     * @return
     */
    public int pop() {
        return this.arr[this.top --] ;
    }

    /**
     * 查询栈顶数据
     * @return
     */
    public int peek() {
        return this.arr[this.top] ;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.top == -1 ;
    }

    /**
     * 判断是否满了
     * @return
     */
    public boolean isFull() {
        return this.top == this.arr.length ;
    }

    public static void main(String [] args) {
        MyStack stack = new MyStack(20) ;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }


}
