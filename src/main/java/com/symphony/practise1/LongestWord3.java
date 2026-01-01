package com.symphony.practise1;

import javax.swing.text.Keymap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class LongestWord3 {
    static void main() {
        List<String> words = List.of("apple", "ant", "apricot", "bat", "banana", "car", "cat", "caterpillar", "dog");
        Collector<String, Map<Character, String>, Map<Character, String>> collector = Collector.of(HashMap::new, (map, val) -> {
                    char c = Character.toUpperCase(val.charAt(0));
                    map.computeIfPresent(c, (_, v) -> v.length() > val.length() ? v : val);
                    map.putIfAbsent(c, val);
                },
                (map1, map2) -> {
                    map2.forEach((key, val) -> map1.merge(key, val, (s1, s2) -> s1.length() > s2.length() ? s1 : s2));
                    return map1;
                }, map -> map);
        Map<Character, String> result = words.stream().collect(collector);
        System.out.println(result);
    }
}
