package com.ordepdev.streams.map;

import java.util.*;

public class MainMerge {

    public static void main(String[] args) {
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        map1.put("one", new ArrayList<String>(Arrays.asList("two", "three")));
        map2.put("two", new ArrayList<String>(Arrays.asList("four", "five")));

        map2.forEach(
                (key, value) ->
                        map1.merge(key, value,
                                (m1, m2) -> {
                                    m1.addAll(m2);
                                    return m1;
                                })
        );

        System.out.println(map1.size());
        System.out.println(map1.toString());
    }

}
