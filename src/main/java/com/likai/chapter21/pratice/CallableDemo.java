package com.likai.chapter21.pratice;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 如果希望任务在完成时能返回一个值可以实现Callable接口
 */
class TaskWithResult implements Callable {

    private int id ;
    public TaskWithResult(int id) {
        this.id = id ;
    }

    @Override
    public Object call() throws Exception {
        return "result of TaskWithResult " + this.id ;
    }
}
public class CallableDemo {

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool() ;
        ArrayList<Future<String>> results = new ArrayList<Future<String>>() ;
        for(int i = 0 ; i < 10; i ++) {
            results.add(exec.submit(new TaskWithResult(i))) ;
        }

        for (Future<String> result : results) {
            //可以使用isDone()方法来查询Future是否完成 如果完成将会产生一个结果可以使用get()方法获取
            //如果直接使用get() 那么get()将会阻塞 直到结果准备就绪
            System.out.println(result.get());
        }

        exec.shutdown();
    }

}
