package com.me.concurrence.lock;

/**
 * @author zhaohaojie
 * @date 2019-01-19 16:59
 */
public class GetTask implements Runnable {
    private LockService lockService;

    public GetTask(LockService lockService){
        this.lockService = lockService;
    }

    @Override
    public void run() {
        try {
//            for (int i=0;i<100;i++){
                lockService.get();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

