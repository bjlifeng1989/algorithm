package com.lifeng.thread.createthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 创建线程方式四-线程池
 * @author: lifeng
 * @create: 2021-12-22 10:57:56
 **/
public class MyThread4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("***********"+i+"********");
        }
    }
}
class TestRunnable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"被调用了");
    }
}

