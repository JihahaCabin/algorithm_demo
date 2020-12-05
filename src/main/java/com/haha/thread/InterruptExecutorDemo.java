package com.haha.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            try {
//                Thread.sleep(3000);
//                System.out.println("Thread run");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        //调用executor的shutdown方法，会等待所有线程执行完毕后，再关闭
//        executorService.shutdown();
        //调用executor的shutdownNow方法，相当于调用每个线程的interrupt方法，不会等待所有线程执行完毕后，此时会跑出interruptedException
//        executorService.shutdownNow();


        //如果想终止部分线程，需要通过submit来提交线程，通过返回的Future对象，调用该对象的cancel(true)方法，中断线程
        Future<?> future = executorService.submit(() -> {
            System.out.println("submit a thread");
            try {
                Thread.sleep(3000);
                System.out.println("thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000);
        future.cancel(true);

        System.out.println("Main run");
    }
}
