package com.symphony.practise1;

import java.util.*;
import java.util.stream.Collector;

public class CustomCollector1 {
    static void main() {
        List<String> words = List.of("apple", "bat", "ball", "cat", "car", "dog", "ant", "axe", "zebra", "zip", "zoo", "alpha", "beta", "cup");
        Collector<String, LinkedHashMap<Character, LinkedHashSet<String>>, Map<Character, String>> collector = Collector.of(LinkedHashMap::new,
                (map, val) -> {
                    char c = Character.toUpperCase(val.charAt(0));
                    map.computeIfAbsent(c, k -> new LinkedHashSet<>()).add(val);
                },
                (map1, map2) -> {
                    map2.forEach((key, val) -> map1.merge(key, val, (s1, s2) -> {
                        s1.addAll(s2);
                        return s1;
                    }));
                    return map1;
                },
                map -> {
                    Map<Character, String> result = new HashMap<>();
                    map.forEach((key, val) -> result.put(key, String.join(",", val)));
                    return result;
                }
        );

        Map<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
