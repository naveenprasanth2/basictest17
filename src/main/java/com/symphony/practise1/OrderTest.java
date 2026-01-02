package com.symphony.practise1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderTest {
    static void main() {
        List<Order> orders = List.of(
                new Order("Alice", 150.0, true),
                new Order("Bob", 50.0, false),
                new Order("Charlie", 200.0, true),
                new Order("David", 30.0, false),
                new Order("Eve", 100.0, true)
        );

        Map<Boolean, Double> result = orders.stream()
                .collect(Collectors.partitioningBy(Order::isCompleted, Collectors.summingDouble(Order::amount)));
        System.out.println(result);

    }
}
