package com.symphony.practise1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class LongestWord6 {
    static void main() {
        List<String> words = List.of("apple", "ant", "apricot", "bat", "banana", "car", "cat", "caterpillar", "dog");
        Collector<String, HashMap<Character, String>, Map<Character, String>> collector = Collector.of(
                HashMap::new,
                (map, val) -> {
                    char c = Character.toLowerCase(val.charAt(0));
                    map.merge(c, val, (v, v1) -> v.length() > v1.length() ? v : v1);
                },
                (map1, map2) -> {
                    map1.forEach((k, v) -> map2.merge(k, v, (v1, v2) -> v1.length() > v2.length() ? v1 : v2));
                    return map1;
                },
                x -> x
        );
        Map<Character, String> res = words.stream().collect(collector);
        System.out.println(res);
    }
}
