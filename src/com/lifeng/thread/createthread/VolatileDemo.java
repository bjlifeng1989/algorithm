package com.lifeng.thread.createthread;

import java.util.concurrent.TimeUnit;

/**
 * @description: 测试volatile可见性
 * @author: lifeng
 * @create: 2021-12-27 17:05:03
 **/
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"\t come in ");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myData.addTo60();
        System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
    },"AAA").start();
        //thread AAA 修改number的值后，如果不用volatile修饰，则会在while处陷入死循环，当使用volatile修饰时，AAA线程变更数据后直接写入主内存，主线程读取的是60，则不会陷入死循环，直接结束
        while(myData.number ==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
