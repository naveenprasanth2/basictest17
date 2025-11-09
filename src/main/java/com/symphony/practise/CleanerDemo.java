package com.symphony.practise;

import java.lang.ref.Cleaner;

public class CleanerDemo {
   public final Cleaner.Cleanable cleanable = Cleaner
           .create().register(this, () -> System.out.println("Cleaned"));
   static void main() throws InterruptedException {
        CleanerDemo cleanerDemo = new CleanerDemo();
        cleanerDemo = null;
        System.gc();
        Thread.sleep(1000);
    }
}
