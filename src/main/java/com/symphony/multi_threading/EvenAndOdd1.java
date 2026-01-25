package com.symphony.multi_threading;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenAndOdd1 implements Runnable{
    private final AtomicInteger count = new AtomicInteger(1);
    private final Object object;

    public EvenAndOdd1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count.get() <= 10) {
            if (count.get() %2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("The value is " + count.get() + " and the thread name is " + Thread.currentThread().getName());
                    count.getAndIncrement();
                    try {
                        object.wait();
                    } catch (InterruptedException _) {
                        throw new RuntimeException();
                    }
                }
            }

            if (count.get() %2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("The value is " + count.get() + " and the thread name is " + Thread.currentThread().getName());
                    count.getAndIncrement();
                    object.notify();
                }
            }
        }
    }
}
