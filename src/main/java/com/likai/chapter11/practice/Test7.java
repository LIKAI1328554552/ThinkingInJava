package com.likai.chapter11.practice;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by likai on 2018/10/21.
 */
public class Test7 {
    public static void main(String [] args) {
        PriorityQueue<Double> queue = new PriorityQueue<>() ;
        /*Random random = new Random(47) ;
        for(int i = 0 ; i < 20; i ++) {
            queue.offer(random.nextDouble()) ;
        }
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }*/

        PriorityQueue<Student> students = new PriorityQueue<>() ;
        for(int i = 0 ; i < 10; i ++) {
            students.offer(new Student("1")) ;
        }

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
