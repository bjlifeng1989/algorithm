package com.lifeng.thread.createthread;

/**
 * @description: 创建线程方式一继承thread
 * @author: lifeng
 * @create: 2021-12-22 10:41:11
 **/
public class MyThread1 extends Thread{
    public void run(){
        System.out.println("创建线程方式一继承thread："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
         MyThread1 myThread1 = new MyThread1();
         myThread1.run();
    }
}


