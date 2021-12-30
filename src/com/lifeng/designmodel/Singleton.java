package com.lifeng.designmodel;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

/**
 * @description: 单例模式DCL
 * @author: lifeng
 * @create: 2021-12-30 15:59:57
 **/
public class Singleton {

    public static volatile Singleton instance = null;
    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"\t 我是singleton的构造方法");
    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance ==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
