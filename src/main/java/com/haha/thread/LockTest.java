package com.haha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = -0; i < 10; i++) {
                System.out.print(i + "  ");
            }
        } finally {
            //确保释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockTest.func());
        executorService.execute(() -> lockTest.func());

    }
}
