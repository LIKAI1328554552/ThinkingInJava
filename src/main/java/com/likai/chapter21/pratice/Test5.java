package com.likai.chapter21.pratice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Fibonacci2 implements Callable {
    private int n ;
    public Fibonacci2() {
        super();
    }

    public Fibonacci2(int n) {
        this.n = n ;
    }

    public int f(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2 ;
        } else {
            return f(n -2) + f(n - 1) ;
        }
    }
    @Override
    public Object call() throws Exception {
        int result = 0 ;
        for(int i = 1 ; i <= this.n; i ++) {
            result += f(i) ;
        }

        return result ;
    }
}
public class Test5 {
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<Future<Integer>>() ;
        for(int i = 0 ; i < 10; i ++) {
            results.add(exec.submit(new Fibonacci2(i+10))) ;
        }

        for (Future<Integer> result : results) {
            //可以使用isDone()方法来查询Future是否完成 如果完成将会产生一个结果可以使用get()方法获取
            //如果直接使用get() 那么get()将会阻塞 直到结果准备就绪

            if(result.isDone()) {
                System.out.println(result.get());
            } else {
                System.out.println("结果未就绪");
            }

            /* 结果
             * 231
             * 375
             * 结果未就绪
             * 985
             * 结果未就绪
             * 结果未就绪
             * 结果未就绪
             * 结果未就绪
             * 结果未就绪
             * 结果未就绪
             */

            System.out.println(result.get());
            /* 结果
             * 231
             * 375
             * 608
             * 985
             * 1595
             * 2582
             * 4179
             * 6763
             * 10944
             * 17709
             */
        }

        exec.shutdown();
    }
}
