package com.symphony.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue4 {
    private final Queue<Integer> queue;
    private final ReentrantLock lock;
    private final Condition spacesAvailable;
    private final Condition itemsAvailable;
    private final int size;

    public BlockingQueue4(int size) {
        this.size = size;
        queue = new LinkedList<>();
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
            itemsAvailable.signalAll();
        } catch (Exception _) {
            Thread.currentThread().interrupt();
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
            System.out.println(queue.poll());
            spacesAvailable.signalAll();
        } catch (Exception _) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    static void main() {

    }
}
