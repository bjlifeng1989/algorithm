package com.lifeng.thread.createthread;

/**
 * @description: 测试volatile
 * @author: lifeng
 * @create: 2021-12-27 17:04:05
 **/
public class MyData {

    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }
}
