package com.symphony.multi_threading;

public class EvenAndOdd implements Runnable {
    private int count = 0;
    private final Object object;

    public EvenAndOdd(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count <= 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("The thread name " + Thread.currentThread().getName() + " and value is " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("The thread name " + Thread.currentThread().getName() + " and value is " + count);
                    count++;
                    object.notify();
                }
            }

        }
    }
}
