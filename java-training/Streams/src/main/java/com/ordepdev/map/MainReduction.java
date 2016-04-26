package com.ordepdev.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {

    static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction) {
        int result = valueIfEmpty;
        for (int value: values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

        //BinaryOperator<Integer> operation = (i1, i2) -> i1 + i2; // associative
        //BinaryOperator<Integer> operation = (i1, i2) -> Integer.max(i1, i2); // associative
        BinaryOperator<Integer> operation = (i1, i2) -> (i1+i2)*(i1+i2); // non-associative

        int reduction = reduce(ints, 0, operation);
        int reduction1 = reduce(ints1, 0, operation);
        int reduction2 = reduce(ints2, 0, operation);
        // wrong result in parallel for non-associative operations
        int reduction3 = reduce(Arrays.asList(reduction1, reduction2), 0, operation);

        System.out.println(reduction);
        System.out.println(reduction1);
        System.out.println(reduction2);
        System.out.println(reduction3);
    }
}
