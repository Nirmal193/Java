package com.design.Semaphore;

import java.util.concurrent.Semaphore;

public class SendingThread {
    Semaphore semaphore = null;
    public SendingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public Runnable run() throws InterruptedException {
        int x = 10;
        while(x!=0){
            //do something
            System.out.println("Semaphore target send");
            this.semaphore.tryAcquire();
            x--;
        }
        return null;
    }
}
