package com.volatileAtomic;

/**
 * volatile 不能保证原子性
 */
public class Demo {
    volatile int i;

    public void incr() {
        i++;
    }

    public static void main(String[] args) {
        new Demo().incr();
    }

}
