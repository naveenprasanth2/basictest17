package com.symphony.maps;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.merge(1, -1, (x, y) -> (x + y) == 0 ? null : x + y);
        IO.println(map);
    }
}
