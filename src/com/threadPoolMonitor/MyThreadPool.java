package com.threadPoolMonitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zheng gongming on 2018/12/31.
 */
public class MyThreadPool  implements Runnable {
    static ExecutorService executorService=
            MyExecutor.newMyFixedThreadPool(3);

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            executorService.execute(new MyThreadPool());

        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程干活完毕..."+Thread.currentThread().getName());
    }
}
