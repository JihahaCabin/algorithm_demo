package com.haha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Lock 来获取一个 Condition 对象
 * 调用 await() 方法使线程等待，
 * 其它线程调用 signal() 或 signalAll() 方法唤醒等待的线程。
 */
public class AwaitSignalTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AwaitSignalTest awaitSignalTest = new AwaitSignalTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> awaitSignalTest.after());
        executorService.execute(() -> awaitSignalTest.before());
    }
}
