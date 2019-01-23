package com.me.concurrence.lock;

import com.me.concurrence.threadPool.MyPool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhaohaojie
 * @date 2019-01-19 17:01
 */
@Slf4j
public class testMain {

    public static void main(String[] args) {
        LockService service = new LockService();
        Runnable[] setRunnables = new SetTask[10];
        Runnable[] getRunnables = new GetTask[10];
        MyPool pool = new MyPool();
        for (int i =0;i<2;i++){
            setRunnables[i] = new SetTask(service);
//            Thread t1 = new Thread(setRunnables[i],"setThread"+i);
            getRunnables[i] = new GetTask(service);
//            Thread t2 = new Thread(getRunnables[i],"getThread"+i);
            pool.addToQueue(setRunnables[i]);
            pool.addToQueue(getRunnables[i]);
        }
        try {
            Thread.sleep(3000);
            service.awareAllWaitingThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

