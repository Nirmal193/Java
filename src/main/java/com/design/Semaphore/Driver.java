package com.design.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);

        Semaphore semaphore = new Semaphore(slots);

        SendingThread sender = new SendingThread(semaphore);

        ReceivingThread receiver = new ReceivingThread(semaphore);
try {
        IntStream.range(0, slots)
                .forEach(user -> {
                    try {
                        executorService.execute(sender.run());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        executorService.shutdown();
        receiver.run();
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
