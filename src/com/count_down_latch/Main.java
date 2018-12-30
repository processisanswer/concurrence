package com.count_down_latch;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(()->{
            System.out.println(new Date());
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"-倒数-"+countDownLatch.getCount());
        },"t1").start();
        new Thread(()->{
            System.out.println(new Date());
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"-倒数-"+countDownLatch.getCount());

        },"t2").start();
        new Thread(()->{
            System.out.println(new Date());
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"-倒数-"+countDownLatch.getCount());

        },"t3").start();
        countDownLatch.await();
        System.out.println("所有线程执行完毕...");

    }
}
