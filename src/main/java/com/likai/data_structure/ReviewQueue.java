package com.likai.data_structure;

public class ReviewQueue {

    private int [] data ;

    private int size ;

    //队头
    private int start;
    //队尾
    private int end;

    public ReviewQueue() {
        this.data = new int[50] ;
        this.size = 0 ;
        this.start = 0 ;
        this.end = - 1 ;
    }



    public ReviewQueue(int size) {
        this.data = new int[size] ;
        this.size = 0 ;
        this.start = 0 ;
        this.end = - 1 ;
    }

    /**
     * 从队尾添加
     * @param data
     */
    public void add(int data) {
        // 如果尾指针为数组长度了 那么让其回到初始位置
        if(this.end == this.data.length -1) {
            this.end = -1 ;
        }

        this.data[++this.end] = data ;
        this.size ++ ;
    }

    /**
     * 从队头出队
     */
    public int remove() {
        int value = this.data[this.start ++] ;

        if(this.start == this.data.length) {
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
        return this.size == this.data.length ;
    }

    public static void main(String [] args) {
        ReviewQueue queue = new ReviewQueue(5) ;
        queue.add(10);
        queue.add(11);
        queue.add(12);
        System.out.println(queue.remove()); ;
        queue.add(13);
        queue.add(16);
        /*queue.add(17);*/


        while (!queue.isEmpty()) {
            System.out.print(queue.remove());
        }
    }
}
