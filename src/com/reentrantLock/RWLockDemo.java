package com.reentrantLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zheng gongming on 2018/12/29.
 */
public class RWLockDemo {
    //共享锁 在同一时刻可以有多个线程获得锁
    //读锁 写锁 读多写少
    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock reentrantReadWriteLock =
            new ReentrantReadWriteLock();
    static Lock read = reentrantReadWriteLock.readLock();
    static Lock write = reentrantReadWriteLock.writeLock();

    //缓存的更新和读取的时候
    public static final Object get(String key) {
        read.lock();//读锁
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object set(String key, Object obj) {
        write.lock();//写锁
        try {
            return cacheMap.put(key, obj);
        } finally {
            write.unlock();
        }
    }
}
