package com.me.concurrence.sync;

/**
 * @author zhaohaojie
 * @date 2019-01-21 21:14
 */
public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[200];
        for (int i=0;i<100;i++){
            threads[i] = new CountThread();
        }
        for (int i=0;i<100;i++){
            threads[i].start();
        }
    }
}

