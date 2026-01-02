package com.symphony.practise1;

import java.util.List;
import java.util.stream.Collector;

public class AvaerageLength {
    static void main() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        Collector<String, long[], Double> collector = Collector.of(() -> new long[2],
                (arr, val) -> {
                    arr[0] = val.length();
                    arr[1]++;
                }, (arr1, arr2) -> {
                    arr1[0] += arr2[0];
                    arr1[1] += arr2[1];
                    return arr1;
                }, arr -> arr[1] > 0 ? (double) arr[0] / arr[1] : 0.0);
        Double result = words.stream().collect(collector);
        System.out.println(result);
    }
}
