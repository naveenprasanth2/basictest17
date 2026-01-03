package com.symphony.practise2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class CountWordsByLength {
    static void main() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        Collector<String, HashMap<Integer, Integer>, Map<Integer, Integer>> collector = Collector.of(HashMap::new, (map, str) -> {
            map.put(str.length(), (map.getOrDefault(str.length(), 0) + 1));
        }, (map1, map2) -> {
            map2.forEach((key, val) -> map1.merge(key, val, Integer::sum));
            return map1;
        }, map -> map);
        Map<Integer, Integer> map = words.stream().collect(collector);
        System.out.println(map);
    }
}
