package com.symphony.practise1;

import java.util.List;
import java.util.stream.Collector;

public class LongestWord5 {
    static void main() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        Collector<String, StringBuilder, String> collector = Collector.of(StringBuilder::new, (builder, val) -> {
            if (builder.length() < val.length()) {
                builder.setLength(0);
                builder.append(val);
            }},
            (builder1, builder2) -> builder1.length() > builder2.length() ? builder1 : builder2, x -> x.toString());
        String word = words.stream().collect(collector);

        System.out.println(word);
    }
}
