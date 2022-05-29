package com.design.multithreading;

public class ReneterantLock {
    Lock lock = new Lock();
    public void outer() throws InterruptedException {
        lock.lock();
        inner();
        try{
            //do Something
        }finally {
            lock.unlock();
        }
    }
    public void inner() throws InterruptedException {
        lock.lock();
        try{
            //do Something
        }finally {
            lock.unlock();
        }
    }
}
