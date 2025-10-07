package com.symphony.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<T> {
    private final Queue<T> queue;
    private final int size;
    private final ReentrantLock lock;
    private final Condition spacesAvailable;
    private final Condition itemsAvailable;

    public BlockingQueue1(int size) {
        this.size = size;
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        spacesAvailable = lock.newCondition();
        itemsAvailable = lock.newCondition();
    }

    public void put(T val) {
        lock.lock();
        try {
            while (this.size == queue.size()) {
                spacesAvailable.await();
            }
            System.out.printf("The value %s is ADDED to the queue%n", val);
            queue.offer(val);
            itemsAvailable.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailable.await();
            }
            T t = queue.poll();
            System.out.printf("The value %s is REMOVED to the queue%n", t);
            spacesAvailable.signalAll();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
