package com.symphony.practise;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {
    static void main() {
        List<String> data = List.of("apple", "banana", "cherry");
        String result = data.parallelStream().collect(
                Collector.of(StringBuilder::new, //Supplier
                        (x1, x2) -> x1.append(x2).append(", "), //Accumulator
                        StringBuilder::append, //Combiner
                        sb -> sb.substring(0, sb.length() - 2)) //Finisher
        );
        System.out.println(result);
    }
}
