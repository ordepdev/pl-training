package com.ordepdev.coffeeshop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HamcrestExampleTest {

    @Test
    public void mapShouldCointainValue() {
        Map<String, Integer> values = getValues();

        //Assert.assertTrue(values.containsKey("B"));
        Assert.assertThat(values, Matchers.hasKey("b"));
    }

    private Map<String, Integer> getValues() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("b", 2);
        return map;
    }

    @Test
    public void listOrderingIsIrrelevant() {
        List<Integer> numbers = getNumbers();

        //Assert.assertEquals(5, (int) numbers.get(4));
        Assert.assertThat(numbers, Matchers.hasItem(5));
    }

    private List<Integer> getNumbers() {
        return Arrays.asList(1,2,3,5,4);
    }
}
