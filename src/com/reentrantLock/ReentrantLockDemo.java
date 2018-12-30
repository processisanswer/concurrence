package com.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zheng gongming on 2018/12/29.
 * 重入锁
 *
 */
public class ReentrantLockDemo {
    static Lock lock=new ReentrantLock();
    private static int i=0;
    public static void incr(){

        lock.lock();
        try {
            System.out.println("当前线程："+Thread.currentThread().getName()+"获取锁成功，但是得休息1毫秒...");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        System.out.println("当前线程名称："+Thread.currentThread().getName()+" 执行后i->"+i);
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->{
                ReentrantLockDemo.incr();
            }).start();

        }
        Thread.sleep(3000);
        System.out.println("主线程结束...");
    }

}
