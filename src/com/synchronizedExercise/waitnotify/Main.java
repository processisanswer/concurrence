package com.synchronizedExercise.waitnotify;

/**
 * Created by zheng gongming on 2018/12/29.
 * wait notify test
 */
public class Main {
    public static void main(String[] args) {
        Object obj=new Object();
        //同一把锁
        ThreadWait threadWait=new ThreadWait(obj);
        threadWait.start();
        ThreadNotify threadNotify = new ThreadNotify(obj);
        threadNotify.start();
    }
}
