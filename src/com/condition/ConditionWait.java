package com.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Condition 使用案例
 */
public class ConditionWait  implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWait() {
    }

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            System.out.println("begin -ConditionDemoWait");
            lock.lock();
            //使当前线程进入等待队列并释放锁
            //同时线程状态变为等待状态
            System.out.println(Thread.currentThread().getName()+"释放锁....");
            condition.await();//当前线程会释放锁并等待
            System.out.println(Thread.currentThread().getName()+"重新获取到锁....");
            System.out.println("end -ConditionDemoWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
