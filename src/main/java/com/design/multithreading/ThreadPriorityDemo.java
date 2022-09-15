package com.design.multithreading;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAggregator());

        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        try {
            t2.join();
        }catch (Exception e){
            System.out.println("Exception e");
        }
        System.out.println("Inside main ... ");
    }
}
class EmailCampaign implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            if (i == 5) {
                // Hint to scheduler that thread is willing to
                // yield its current use of CPU
                Thread.currentThread().yield();
            }
        }
    }
}
class DataAggregator implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
