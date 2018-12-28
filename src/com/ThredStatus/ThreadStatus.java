package com.ThredStatus;

import java.util.concurrent.TimeUnit;

public class ThreadStatus {
    public static void main(String[] args) {
        //time-waiting
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "time-waiting").start();
        //waiting，线程在ThreadStatus类锁上通过wait进行等待
        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatus.class) {
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting").start();
        //线程在ThreadStatus加锁后，不会释放锁
        new Thread(new BlockedDemo(),"BlockedDemo-01").start();
        new Thread(new BlockedDemo(),"BlockedDemo-02").start();

    }
    static class BlockedDemo extends Thread{
        public void run(){
            synchronized (BlockedDemo.class){
                try {
                    System.out.println(Thread.currentThread().getName()+"正在执行...");
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
