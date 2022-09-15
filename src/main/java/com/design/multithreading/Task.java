package com.design.multithreading;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("nirmal");
        go();
    }
    private void go(){
        System.out.println("inside the go method");
        more();
    }
    private void more() {
        System.out.println("Inside more ...");
    }
}
