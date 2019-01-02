package com.threadPoolMonitor;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by zheng gongming on 2018/12/31.
 * 线程监控
 *
 */
public class MyExecutor extends ThreadPoolExecutor {
    //beforeExecutor、afterExecutor、shutdown
    private ConcurrentMap<String,Date> startTime;

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.startTime=new ConcurrentHashMap<>();
    }

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    public void shutdown() {
        System.out.println("已经执行的任务数量:"+this.getCompletedTaskCount());
        System.out.println("当前活动的线程数:"+this.getActiveCount());
        System.out.println("当前排队的线程数:"+this.getQueue().size());

        super.shutdown();

    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTime.put(String.valueOf(r.hashCode()),new Date());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date stateDate=startTime.remove(String.valueOf(r.hashCode()));
        Date finishDate=new Date();
        long dif=finishDate.getTime()-stateDate.getTime();
        System.out.println("任务耗时:"+dif);
        System.out.println("最大允许的线程数:"+this.getMaximumPoolSize());
        System.out.println("线程的空闲时间："+this.getKeepAliveTime(TimeUnit.MILLISECONDS));
        System.out.println("任务总数:"+this.getTaskCount());
        super.afterExecute(r, t);
    }

    public static ExecutorService newMyFixedThreadPool(int nThreads) {
        return new MyExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

}
