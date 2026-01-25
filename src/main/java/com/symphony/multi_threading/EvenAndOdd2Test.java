package com.symphony.multi_threading;

public class EvenAndOdd2Test {
    static void main() throws InterruptedException {
        EvenAndOdd2  evenAndOdd2 = new EvenAndOdd2(new Object());
        Thread t1 = new Thread(evenAndOdd2, "even");
        Thread t2 = new Thread(evenAndOdd2, "odd");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
