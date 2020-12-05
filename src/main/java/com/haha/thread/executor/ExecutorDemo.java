package com.haha.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        // cachedTreadPool,一个任务创建一个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("good");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        // fixedThreadPool.固定线程池大小
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService1.execute(() -> {
                System.out.println("good1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService1.shutdown();
        // singleThreadExecutor，容量为1的线程池，相当于大小为 1 的 FixedThreadPool
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService2.execute(() -> {
                System.out.println("good2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService2.shutdown();


    }
}
