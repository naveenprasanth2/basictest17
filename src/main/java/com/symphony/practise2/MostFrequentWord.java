package com.symphony.practise2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class MostFrequentWord {
    static void main() {
        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana", "banana", "date");
        Collector<String, HashMap<String, Integer>, String> collector = Collector.of(HashMap::new, (map, val) -> {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }, (map1, map2) -> {
                    map2.forEach((key, val) -> map1.merge(key, val, Integer::sum));
                    return map1;
                }, map ->
                        map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("No such string")
        );
        String result = words.stream().collect(collector);
        System.out.println(result);
    }
}
