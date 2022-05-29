package com.design.multithreading;

public class Lock {
    private boolean isLocked = false;
    private Thread lockedBy = null; //this Thread is checked because for the current thread should enter the lock  method
    private int lockedCount = 0;
    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while(isLocked && lockedBy != currentThread)
            wait();
        isLocked = true;
        lockedBy = currentThread;
        lockedCount++;
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == lockedBy) {
            lockedCount--;
            if(lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
