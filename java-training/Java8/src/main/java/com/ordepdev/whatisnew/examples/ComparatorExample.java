package com.ordepdev.whatisnew.examples;

import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        Comparator<String> comparator = (String s1, String s2) ->
                Integer.compare(s1.length(), s2.length());

        Comparator<Integer> comparator1 = (i1, i2) ->
                Integer.compare(i1, i2);

        Comparator<Integer> comparator2 = Integer::compare;

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list);

        list.forEach(System.out::println);
    }
}
