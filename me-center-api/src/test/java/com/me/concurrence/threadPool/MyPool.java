package com.me.concurrence.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaohaojie
 * @date 2019-01-20 15:48
 */
public class MyPool {
    public static final Integer corePoolSize = 20;
    public static final Integer maxPoolSize = 20;

    private BlockingQueue queue = new LinkedBlockingDeque();
    private ThreadPoolExecutor poolExecutor =
            new ThreadPoolExecutor(corePoolSize,maxPoolSize,60, TimeUnit.SECONDS,queue, new ThreadPoolExecutor.AbortPolicy());

    public void addToQueue(Runnable task){
        poolExecutor.execute(task);
    }
}

