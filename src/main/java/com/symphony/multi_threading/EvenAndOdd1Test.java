package com.symphony.multi_threading;

public class EvenAndOdd1Test {
    static void main() throws InterruptedException {
        EvenAndOdd1 evenAndOdd1 = new EvenAndOdd1(new Object());
        Thread thread1 = new Thread(evenAndOdd1, "even");
        Thread thread2 = new Thread(evenAndOdd1, "odd");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
