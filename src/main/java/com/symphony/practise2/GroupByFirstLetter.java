package com.symphony.practise2;

import java.util.*;
import java.util.stream.Collector;

public class GroupByFirstLetter {
    static void main() {
        List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry", "date");
        Collector<String, TreeMap<Character, TreeSet<String>>, TreeMap<Character, String>> collector = Collector.of(() -> new TreeMap<>(Character::compareTo), (map, val) -> {
            char c = Character.toUpperCase(val.charAt(0));
            map.computeIfAbsent(c, _ -> new TreeSet<>(String::compareTo)).add(val);
        }, (map1, map2) -> {
            map2.forEach((key, val) -> map1.merge(key, val, (val1, val2) -> {
                val1.addAll(val2);
                return val1;
            }));
            return map1;
        }, map -> {
            TreeMap<Character, String> sortedMap = new TreeMap<>();
            map.forEach((key, val) -> sortedMap.put(key, String.join(",", val)));
            return sortedMap;
        });

        TreeMap<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
