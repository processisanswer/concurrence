package com.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zheng gongming on 2018/12/30.
 */
public class ThreadPool implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:"+Thread.currentThread().getName());

    }
    static ExecutorService service= Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            service.execute(new ThreadPool());
        }
        service.shutdown();
    }
}
