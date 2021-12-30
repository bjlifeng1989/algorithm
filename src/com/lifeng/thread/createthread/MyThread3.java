package com.lifeng.thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 创建线程方式三-实现Callable接口
 * @author: lifeng
 * @create: 2021-12-22 10:50:36
 **/
public class MyThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("创建线程方式三-实现Callable接口:"+Thread.currentThread().getName());
        return 5;
    }

    public static void main(String[] args) {
/*        FutureTask<Integer> futureTask = new FutureTask<Integer>(
                (Callable<Integer>)()->{return 5;}
        );
        new Thread(futureTask,"有返回值的线程").start();
        try {
            System.out.println(Thread.currentThread().getName()+"子线程的返回值："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        MyThread3 thread3 = new MyThread3();
        FutureTask<Integer> futureTask = new FutureTask<>(thread3);
        new Thread(futureTask).start();
    }
}
