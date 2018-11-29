package com.likai.data_structure;

/**
 * Created by likai on 2018/11/20.
 * 栈复习
 */
public class ReviewStack {
    private int [] array ;

    private int top ;

    public ReviewStack() {
        this.array = new int [50] ;
        this.top = -1 ;
    }

    public ReviewStack(int size) {
        this.array = new int [size] ;
        this.top = -1 ;
    }

    /**
     * 压栈
     * @param value
     */
    public void push(int value) {
        this.array[++ this.top] = value ;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public int pop() {
        return this.array[this.top --] ;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek() {
        return this.array[this.top] ;
    }


    public static void main(String [] args) {
        ReviewStack stack = new ReviewStack() ;
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        stack.push(10000);
        stack.push(100000);


        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());

    }

}
