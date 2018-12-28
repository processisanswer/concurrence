package com.interrupt.reset;

import java.util.concurrent.TimeUnit;

public class InterruptResetDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                boolean bool = Thread.currentThread().isInterrupted();
                if (bool) {
                    System.out.println("bofore:" + bool);
                    Thread.interrupted();//对线程进行复位，中断表示为false
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();//设置中断标识，中断标识为true
    }
}
