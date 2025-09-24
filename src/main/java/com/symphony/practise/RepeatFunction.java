package com.symphony.practise;

public class RepeatFunction {
    int count = 1;

    @Repeat(times = 5)
    public void test() {
        System.out.println("I'm repeating " + count++ + " times");
    }
}
