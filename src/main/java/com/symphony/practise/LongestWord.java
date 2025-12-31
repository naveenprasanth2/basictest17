package com.symphony.practise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class LongestWord {
    static void main() {
        List<String> words = List.of("apple", "ant", "apricot", "bat", "banana", "car", "cat", "caterpillar", "dog");
        Map<Character, String> result = words.stream().collect(Collector.of(
                HashMap::new,
                (map, val) -> {
                    if (map.containsKey(val.charAt(0))) {
                        if (map.get(val.charAt(0)).length() < val.length())
                            map.put(val.charAt(0), val);
                    } else {
                        map.put(val.charAt(0), val);
                    }
                },
                (map1, map2) -> {
                    map2.forEach((k, v) -> map1.merge(k, v, (w1, w2) -> w1.length() > w2.length() ? w1 : w2));
                    return map1;
                }
        ));
        System.out.println(result);
    }
}
