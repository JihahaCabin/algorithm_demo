package com.haha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore类似于系统中的信号量，控制对互斥资源的访问线程数
 * demo:每次只有三个客户端可以访问
 */
public class SemaPhoreTest {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(() -> {
                System.out.println("start");
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
    }
}
