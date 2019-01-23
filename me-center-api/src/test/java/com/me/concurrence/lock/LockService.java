package com.me.concurrence.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaohaojie
 * @date 2019-01-19 16:12
 */
public class LockService {
    private ReentrantLock lock;
    private Condition condition;
    private List<String> codeList;

    public LockService(){
        super();
        //默认 公平锁
        lock = new ReentrantLock(false);
        condition = lock.newCondition();
        codeList = new ArrayList<String>();
    }

    public void set() throws InterruptedException {
        lock.lock();
        System.out.println("now is ;"+Thread.currentThread().getName()+"持有此lock的次数："+lock.getHoldCount());
        System.out.println("now is ;"+Thread.currentThread().getName()+"等待获取锁的线程数："+lock.getQueueLength());
        System.out.println("now is ;"+Thread.currentThread().getName()+"等待获取condition的线程数："+lock.getWaitQueueLength(condition));
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasQueuedThreads()："+lock.hasQueuedThreads());
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasWaiters(condition)："+lock.hasWaiters(condition));
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasQueuedThread(Thread.currentThread())："+lock.hasQueuedThread(Thread.currentThread()));
        if (codeList.size()>0){
            System.out.println(Thread.currentThread().getName()+":有数据，等待被消费");

            condition.await();
        }
        String finalString = generateString();
        codeList.add(finalString);
        System.out.println(Thread.currentThread().getName()+"插入数据，数据为："+finalString);
        condition.signalAll();//类似Object.notify()
    }


    private String generateString(){
        Random random = new Random();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int randomNumber = random.nextInt(100);

        int start = random.nextInt(26);
        String randomString = abc.substring(start,random.nextInt(27-start)+start);
        return randomString+String.valueOf(randomNumber);
    }

    public void get() throws InterruptedException {
        lock.lock();
        System.out.println("now is ;"+Thread.currentThread().getName()+"持有此lock的次数："+lock.getHoldCount());
        System.out.println("now is ;"+Thread.currentThread().getName()+"等待获取锁的线程数："+lock.getQueueLength());
        System.out.println("now is ;"+Thread.currentThread().getName()+"等待获取condition的线程数："+lock.getWaitQueueLength(condition));
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasQueuedThreads()："+lock.hasQueuedThreads());
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasWaiters(condition)："+lock.hasWaiters(condition));
        System.out.println("now is ;"+Thread.currentThread().getName()+"lock.hasQueuedThread(Thread.currentThread())："+lock.hasQueuedThread(Thread.currentThread()));
        if (codeList.size()<=0){
            System.out.println(Thread.currentThread().getName()+":没有数据，等待插入");
            condition.await();
        }
        System.out.println(Thread.currentThread().getName()+"读取到数据为："+codeList.get(0)+",and remove it.");
        codeList.remove(0);
        condition.signalAll();
    }

    public void awareAllWaitingThreads(){
        lock.lock();
        condition.signalAll();
        System.out.println("唤醒所有！");
    }
}

