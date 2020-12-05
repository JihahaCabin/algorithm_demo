package com.haha.thread;

public class InterruptDemo {

    public static void main(String[] args) {
        /**
         * 通过调用一个线程的 interrupt() 来中断该线程，
         * 如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。
         * 但是不能中断 I/O 阻塞和 synchronized 锁阻塞,如果线程没有在阻塞中，也不能结束。
         */
        Thread thread = new Thread(new MyThread1());
        thread.start();
        thread.interrupt();
        System.out.println("main run");

        /**
         * 为了能在没有阻塞的情况下结束线程，可以在线程中，调用isInterrupted()，判断是否处于中断状态
         * 从而结束线程
         */
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread1 run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("myThread2");
        while (!this.isInterrupted()) {
            System.out.println("run");
        }
    }
}
