
package com.synchronizedExercise;

/**
 * synchronized 关键字
 */
public class SynchronizedDemo1 {
    private static int count=0;
    private static void inc(){
        synchronized (SynchronizedDemo1.class){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo1.inc()).start();
            Thread.sleep(3000);
            System.out.println("运行结果:"+count);
        }
    }
}
