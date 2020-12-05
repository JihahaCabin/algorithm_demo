package com.haha.thread.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现接口 VS 继承 Thread
 * 实现接口会更好一些，因为：
 * Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；
 * 类可能只要求可执行就行，继承整个 Thread 类开销过大。
 */
public class ThreadDemo {

    public static void main(String[] args) {
        //1.运行runable
        MyRunable myRunable = new MyRunable();
        Thread thread = new Thread(myRunable);
        thread.start();
        //2. 实现Callable,有返回值
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(myCallable);
        Thread thread1 = new Thread(ft);
        thread1.start();
        try {
            //阻塞直到取到值
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //3. 继承 Thread 类
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

//1. 实现 Runnable 接口
class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable");
    }
}

//2. 实现Callable,有返回值
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable");
        Thread.sleep(4000);
        return 1;
    }
}

//3. 继承 Thread 类
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread");
    }
}