package com.symphony.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private Queue<Integer> queue;
    private ReentrantLock lock;
    private Condition spacesAvailable;
    private Condition itemsAvailable;
    private int size;

    public BlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.itemsAvailable = lock.newCondition();
        this.spacesAvailable = lock.newCondition();
    }

    public void add(int val) {
        lock.lock();
        try {
            while (queue.size() == size) {
                spacesAvailable.await();
            }
            queue.offer(val);
            System.out.println("The Item is been added and its value is " + val);
            itemsAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailable.await();
            }
            System.out.println("The Item is been removed and its value is " + queue.poll());
            spacesAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
