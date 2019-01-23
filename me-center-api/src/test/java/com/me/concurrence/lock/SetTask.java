package com.me.concurrence.lock;

/**
 * @author zhaohaojie
 * @date 2019-01-19 16:58
 */
public class SetTask implements Runnable {
    private LockService lockService;

    public SetTask(LockService lockService){
        this.lockService = lockService;
    }

    @Override
    public void run() {
        try {
//            for (int i=0;i<2;i++){
                lockService.set();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

