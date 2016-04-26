package com.ordepdev.streams;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreams {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4);
        stream.forEach(System.out::println);

        Stream<String> streamOfStrings = Stream.generate(() -> "one");
        streamOfStrings.limit(5).forEach(System.out::println);

        Stream<String> streamOfStrings1 = Stream.iterate("+", s -> s + "+");
        streamOfStrings1.limit(5).forEach(System.out::println);

        IntStream streamOfInts = ThreadLocalRandom.current().ints();
        streamOfInts.limit(5).forEach(System.out::println);
    }
}
