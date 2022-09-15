package com.design.multithreading;

import java.util.concurrent.TimeUnit;

public class FirstThread {
    public static void main(String[] args) {
        Task task= new Task();
        Thread thread = new Thread(task);
        thread.start();
        try {
            //Thread.sleep(3000);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("inside main method");
    }
}
