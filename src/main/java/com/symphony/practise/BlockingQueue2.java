package com.symphony.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2 {
    private int size;
    private Queue<Integer> queue;
    private ReentrantLock lock;
    private Condition spacesAvailable;
    private Condition itemsAvailable;

    public BlockingQueue2(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        spacesAvailable = lock.newCondition();
        itemsAvailable = lock.newCondition();
    }

    public void put(int val) {
        lock.lock();
        try {
            while (queue.size() == size) {
                spacesAvailable.await();
            }
            queue.add(val);
            System.out.println("The value" + val + " is added inside the queue ");
            itemsAvailable.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailable.await();
            }
            System.out.println("The value" + queue.poll() + " is removed from the queue ");
            spacesAvailable.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
