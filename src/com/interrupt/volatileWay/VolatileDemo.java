package com.interrupt.volatileWay;

/**
 * Created by zheng gongming on 2018/12/28.
 */
public class VolatileDemo {
    private volatile static boolean stop=false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop=true;
    }

}
