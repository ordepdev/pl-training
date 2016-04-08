package com.ordepdev.generics.examples;

import java.util.AbstractList;
import java.util.Arrays;

public class CustomArrayList<T> extends AbstractList<T> {

    private Object[] values;

    public CustomArrayList() {
        values = new Object[0];
    }

    @Override
    public boolean add(final T o) {
        Object[] newValues = Arrays.copyOf(values, size() + 1);
        newValues[size()] = o;
        values = newValues;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) values[index];
    }

    @Override
    public int size() {
        return values.length;
    }
}
