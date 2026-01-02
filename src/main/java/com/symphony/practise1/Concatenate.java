package com.symphony.practise1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;

public class Concatenate {
    static void main() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        Collector<String, StringBuilder, Optional<String>> collector = Collector.of(StringBuilder::new,
                (builder, val) -> {
                    builder.append(val);
                    builder.append(",");
                }, (builder1, builder2) -> {
                    builder1.append(builder2);
                    return builder1;
                }, builder -> Optional.ofNullable(builder.substring(0, builder.length() - 1)));
        String result = words.stream().collect(collector).orElseThrow(NoSuchElementException::new);
        System.out.println(result);
    }
}
