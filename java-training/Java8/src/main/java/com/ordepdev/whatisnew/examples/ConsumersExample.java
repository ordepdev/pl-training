package com.ordepdev.whatisnew.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumersExample {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one", "two", "three", "four");
        List<String> result = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;

        strings.forEach(c1.andThen(c2));
        result.forEach(c1);
    }
}
