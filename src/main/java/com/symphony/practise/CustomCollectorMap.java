package com.symphony.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class CustomCollectorMap {
    static void main() {
        List<String> words = List.of("apple", "ant", "banana", "bat", "car", "cat");
      Map<Character, List<String>> listMap = words.stream()
                .collect(Collector.of(HashMap::new,
                        (map, val) ->  {
                            if (!map.containsKey(val.charAt(0))){
                                map.put(val.charAt(0), new ArrayList<>());
                            }
                            map.get(val.charAt(0)).add(val);
                        }, (map1, map2) -> {
                            map2.forEach((key, valueList) -> {
                                map1.merge(key, valueList, (list1, list2) -> {
                                    list1.addAll(list2);
                                    return list1;
                                });
                            });
                            return map1;
                        }));

        System.out.println(listMap);
    }
}
