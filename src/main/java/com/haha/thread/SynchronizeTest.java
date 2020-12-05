package com.haha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeTest {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public synchronized void func2() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void func3() {
        synchronized (SynchronizeTest.class) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public synchronized static void func4() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SynchronizeTest test1 = new SynchronizeTest();
        SynchronizeTest test2 = new SynchronizeTest();

        //作用于同一对象
        // 写法一
        ExecutorService executorService1 = Executors.newCachedThreadPool();

        executorService1.execute(() -> test1.func1());
        executorService1.execute(() -> test2.func1());
        // 写法二
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> test1.func2());
        executorService2.execute(() -> test2.func2());

        //作用于整个类
        // 写法一
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        executorService3.execute(() -> test1.func3());
        executorService3.execute(() -> test2.func3());
        // 写法二
        executorService3.execute(() -> SynchronizeTest.func4());
    }
}
