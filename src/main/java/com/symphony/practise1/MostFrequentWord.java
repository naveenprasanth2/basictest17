package com.symphony.practise1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWord {
    static void main() {
        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana", "banana", "apple");
        List<String> result = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElseThrow(NoSuchElementException::new);
        System.out.println(result.getFirst());
    }
}
