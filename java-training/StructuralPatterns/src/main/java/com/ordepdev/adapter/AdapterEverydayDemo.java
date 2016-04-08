package com.ordepdev.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterEverydayDemo {

    public static void main(String[] args) {

        Integer[] arrayOfInts = new Integer[] { 1, 2, 3, 4, 5 };
        List<Integer> listOfInts = Arrays.asList(arrayOfInts);

        System.out.println(arrayOfInts);
        System.out.println(listOfInts);
    }
}
