package com.symphony.multi_threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddUsingStream {
    static void main() {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            IntStream.rangeClosed(1, 10)
                    .forEach(x -> {
                        CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(x)
                                .thenApplyAsync(num -> {
                                    if (num % 2 != 0) {
                                        System.out.println("The thread name " + Thread.currentThread().getName() + " and value is " + num);
                                    }
                                    return num;
                                }, service);
                        oddCompletableFuture.join();
                        CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(x)
                                .thenApplyAsync(num -> {
                                    if (num % 2 == 0) {
                                        System.out.println("The thread name " + Thread.currentThread().getName() + " and value is " + num);
                                    }
                                    return num;
                                }, service);
                        evenCompletableFuture.join();
                    });
            service.shutdown();
        } finally {
            System.out.println("Completed");
        }
    }
}
