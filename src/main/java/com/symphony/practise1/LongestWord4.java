package com.symphony.practise1;

import java.util.List;
import java.util.stream.Collector;

public class LongestWord4 {
    static void main() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        Collector<String, StringBuilder, String> collector = Collector.of(StringBuilder::new, (builder, str) -> {
                    if (builder.length() < str.length()) {
                        builder.setLength(0);
                        builder.append(str);
                    }
                }, (builder1, builder2) ->
                        builder1.length() > builder2.length() ? builder1 : builder2
                , StringBuilder::toString);

        String longestWord = words.stream().collect(collector);
        System.out.println(longestWord);
    }
}
