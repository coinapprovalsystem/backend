package com.me.concurrence.sync;

/**
 * @author zhaohaojie
 * @date 2019-01-21 21:11
 */
public class CountThread extends Thread {
    volatile public static int count;

    /**
     * 这次测试的目的是，线程
     */
    synchronized static public void add(){
        for (int i =0;i<100;i++){
            count++;
        }
        System.out.println(Thread.currentThread().getName()+" running, now count is"+count);
    }

    @Override
    public void run() {
        add();
    }
}

