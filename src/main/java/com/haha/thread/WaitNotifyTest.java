package com.haha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 wait() 挂起期间，线程会释放锁,
 * 使用 notify() notifyAll() 唤醒挂起的线程
 * <p>
 * 注意 wait() 和 sleep() 的区别
 * wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
 * wait() 会释放锁，sleep() 不会。
 */
public class WaitNotifyTest {

    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> waitNotifyTest.after());
        executorService.execute(() -> waitNotifyTest.before());
    }
}
