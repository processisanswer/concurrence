package com.core;

import java.util.concurrent.*;

/**
 * 带返回值的多线程
 */
public class CallableDemo implements Callable<String> {
    private String name;
    private String msg;
    @Override
    public String call() throws Exception {
        return name+":"+msg;
    }

    public CallableDemo(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        CallableDemo callableDemo=new CallableDemo("zhangsan","hello world");
        Future<String> future=executorService.submit(callableDemo);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
