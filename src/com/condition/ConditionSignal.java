package com.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionSignal implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin -ConditionSignal");
        try {
            lock.lock();
            //通知被阻塞的线程，唤醒在等待队列中等待时间最长的节点（首节点）
            //在唤醒节点之前，会将节点移到同步队列中
            //然后自己执行unlock释放锁，
            //被唤醒的线程获得之前的锁继续执行，最后释放锁
            condition.signal();


            System.out.println("end -ConditionSignal,锁未释放...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ConditionSignal 释放锁...");
            lock.unlock();
        }
    }
}
