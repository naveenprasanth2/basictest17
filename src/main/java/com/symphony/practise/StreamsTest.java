package com.symphony.practise;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
    static void main() {
        int sum = Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::valueOf)
                .sum();
        System.out.println(sum);
        Supplier<IntStream> supplier = () -> IntStream.of(1, 2, 3, 4, 5);
        int addedValue = supplier.get().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
        System.out.println(addedValue);
    }
}
