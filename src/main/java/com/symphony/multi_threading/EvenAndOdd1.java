package com.symphony.multi_threading;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenAndOdd1 implements Runnable {
    private final AtomicInteger count = new AtomicInteger(1);
    private final Object object;

    public EvenAndOdd1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (count.get() > 10) {
                    object.notifyAll(); // Notify other threads before exiting
                    break;
                }

                if (count.get() % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                    System.out.println("The value is " + count.get() + " and the thread name is " + Thread.currentThread().getName());
                    count.getAndIncrement();
                    object.notify();
                } else if (count.get() % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                    System.out.println("The value is " + count.get() + " and the thread name is " + Thread.currentThread().getName());
                    count.getAndIncrement();
                    object.notify();
                }

                try {
                    object.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
