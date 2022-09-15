package com.design.forkjoin;

import org.apache.tomcat.jdbc.pool.PoolUtilities;

import java.util.concurrent.ForkJoinPool;

public class Driver {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    }
}
