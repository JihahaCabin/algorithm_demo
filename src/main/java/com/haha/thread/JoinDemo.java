package com.haha.thread;

/**
 * 在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 * 示例中，保证 a 线程的输出先于 b 线程的输出。
 */
public class JoinDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

}

class A extends Thread {

    @Override
    public void run() {
        System.out.println("A");
    }
}

class B extends Thread {

    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");

    }
}