package com.design.Semaphore;

import java.util.concurrent.Semaphore;

public class ReceivingThread {
    Semaphore semaphore = null;
    public ReceivingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public Runnable run() throws InterruptedException {
        int x = 10;
        while(x!=0){
            this.semaphore.release();
            //doSomething;
            x--;
            System.out.println("Semaphore Signal acquired");

        }
        return null;
    }
}
