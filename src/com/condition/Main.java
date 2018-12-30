package com.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        ConditionWait conditionWait=new ConditionWait(lock,condition);

        Thread t1=new Thread(conditionWait);

        t1.start();
        //t1.join();
        System.out.println("t1正在阻塞....");
        ConditionSignal conditionSignal=new ConditionSignal(lock,condition);
        Thread t2=new Thread(conditionSignal);
        t2.start();

    }
}
