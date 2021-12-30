package com.lifeng.thread.createthread;

/**
 * @description: 创建线程方式二实现Runnable接口
 * @author: lifeng
 * @create: 2021-12-22 10:43:42
 **/
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("创建线程方式二实现runnable接口"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        //myThread2.run();
        Thread thread = new Thread(myThread2);
        thread.start();
    }

}
