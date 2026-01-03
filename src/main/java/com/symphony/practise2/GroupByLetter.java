package com.symphony.practise2;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collector;

public class GroupByLetter {
    static void main() {
        List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry", "date");
        Collector<String, LinkedHashMap<Character, LinkedHashSet<String>>, LinkedHashMap<Character, String>> collector = Collector.of(LinkedHashMap::new, (map, val) -> {
            char c = Character.toUpperCase(val.charAt(0));
            map.computeIfAbsent(c, _ -> new LinkedHashSet<>()).add(val);
        }, (map1, map2) -> {
            map2.forEach((key, val) -> map1.merge(key, val, (val1, val2) -> {
                val1.addAll(val2);
                return val1;
            }));
            return map1;
        }, map -> {
            LinkedHashMap<Character, String> finalMap = new LinkedHashMap<>();
            map.forEach((key, set) -> finalMap.put(key, String.join(",", set)));
            return finalMap;
        });
        LinkedHashMap<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
