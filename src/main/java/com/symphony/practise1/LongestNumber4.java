package com.symphony.practise1;

import java.util.*;
import java.util.stream.Collector;

public class LongestNumber4 {
    static void main() {
        List<String> words = List.of("apple", "bat", "ball", "cat", "car", "dog", "ant", "axe", "zebra", "zip", "zoo", "alpha", "beta", "cup");
        Collector<String, LinkedHashMap<Character, LinkedHashSet<String>>, Map<Character, String>> collector = Collector.of(LinkedHashMap::new,
                (map, val) -> {
                    char c = Character.toUpperCase(val.charAt(0));
                    map.computeIfAbsent(c, k -> new LinkedHashSet<>()).add(val);
                }, (map1, map2) -> {
                    map2.forEach((key, set) -> map1.merge(key, set, (s1, s2) -> {
                        s1.addAll(s2);
                        return s1;
                    }));
                    return map1;
                }, map -> {
                    Map<Character, String> finalMap = new HashMap<>();
                    map.forEach((key, set) -> finalMap.put(key, String.join(",", set)));
                    return finalMap;
                }
        );
        Map<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
