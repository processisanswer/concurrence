package com.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    private static  int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("num:" + i);
        }, "interrupt-demp");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
