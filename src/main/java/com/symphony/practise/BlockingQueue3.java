package com.symphony.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue3 {
    private final Queue<Integer> queue;
    private final int size;
    private final ReentrantLock lock;
    private final Condition spacesAvailable;
    private final Condition itemsAvailable;

    public BlockingQueue3(int size) {
        this.size = size;
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        spacesAvailable = lock.newCondition();
        itemsAvailable = lock.newCondition();
    }


    private void put(int val) {
        lock.lock();
        try {
            while (queue.size() == size) {
                spacesAvailable.await();
            }
            queue.add(val);
            itemsAvailable.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private void get() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailable.await();
            }
            System.out.println(queue.poll());
            spacesAvailable.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    static void main() {

    }
}
