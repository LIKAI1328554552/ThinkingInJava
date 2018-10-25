package com.likai.util;

import java.util.LinkedList;

/**
 * 栈
 * @param <T>
 */
public class Stack<T> {
    private LinkedList<T> list = new LinkedList<T>() ;

    /**
     * 将t元素添加到栈中的第一个位置
     * @param t
     */
    public void push(T t) {
        list.addFirst(t);
    }

    /**
     * 取得栈顶第一个元素
     * @return
     */
    public T peek() {
        return list.getFirst() ;
    }

    /**
     * 弹出栈顶第一个元素
     * @return
     */
    public T pop() {
        return list.removeFirst() ;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean empty() {
        return list.isEmpty() ;
    }

    /**
     * 输出结果为字符串
     * @return
     */
    public String toString() {
        return list.toString() ;
    }


}
