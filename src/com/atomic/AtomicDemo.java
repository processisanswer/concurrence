package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static AtomicInteger count=new AtomicInteger(0);

    public static void inc() throws InterruptedException {
        Thread.sleep(1);
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->{
                try {
                    inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("最终 count:"+count.get());
    }
}
