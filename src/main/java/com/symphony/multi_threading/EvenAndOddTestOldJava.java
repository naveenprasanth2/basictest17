package com.symphony.multi_threading;

public class EvenAndOddTestOldJava {
    static void main() throws InterruptedException {
        Object object = new Object();
        Runnable runnable = new EvenAndOdd(object);
        Thread even = new Thread(runnable, "even");
        Thread odd = new Thread(runnable, "odd");
        even.start();
        odd.start();
        even.join();
        odd.join();
    }
}
