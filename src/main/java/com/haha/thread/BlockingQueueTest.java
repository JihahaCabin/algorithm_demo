package com.haha.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * .BlockingQueue 接口有以下阻塞队列的实现
 * FIFO 队列 ：LinkedBlockingQueue、ArrayBlockingQueue（固定长度）
 * 优先级队列 ：PriorityBlockingQueue
 * 提供了阻塞的 take() 和 put() 方法：如果队列为空 take() 将阻塞，直到队列中有内容；如果队列为满 put() 将阻塞，直到队列有空闲位置。
 */
public class BlockingQueueTest {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread {

        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce....");
        }
    }

    private static class Comsumer extends Thread {
        @Override
        public void run() {
            try {
                String value = queue.take();
                System.out.println("result =" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume....");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        //取不到值的消费者，会阻塞等待
        for (int i = 0; i < 5; i++) {
            Comsumer comsumer = new Comsumer();
            comsumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }

}


