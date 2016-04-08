package com.ordepdev.generics;

import com.ordepdev.generics.examples.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomArrayListTest {

    @Test
    public void shouldCreateAListOfIntegers() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void shouldCreateAListOfStrings() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("zar");

        assertEquals(3, list.size());
        assertEquals("foo", list.get(0));
        assertEquals("bar", list.get(1));
        assertEquals("zar", list.get(2));
    }
}
