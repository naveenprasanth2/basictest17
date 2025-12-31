package com.symphony.practise1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {
    static void main() {
        List<String> words = List.of("apple", "bat", "ball", "cat", "car", "dog", "ant", "axe", "zebra", "zip", "zoo", "alpha", "beta", "cup");
        Collector<String, LinkedHashMap<Character, LinkedHashSet<String>>, LinkedHashMap<Character, String>> collector = Collector.of(LinkedHashMap::new,
                (map, val) -> {
                    char c = Character.toUpperCase(val.charAt(0));
                    map.computeIfAbsent(c, k -> new LinkedHashSet<>()).add(val);
                },
                (map1, map2) -> {
                    map2.forEach((key, set) -> map1.merge(key, set, (s1, s2) -> {
                        s1.addAll(s2);
                        return s1;
                    }));
                    return map1;
                },
                map -> {
                    LinkedHashMap<Character, String> finalMap = new LinkedHashMap<>();
                    map.forEach((key, val) -> finalMap.put(key, String.join(",", val)));
                    return finalMap;
                }
        );
        LinkedHashMap<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
