package com.ordepdev.streams.comparator;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static <U> Comparator<U> comparing(Function<U, Comparable> f) {
        return (t1, t2) -> f.apply(t1).compareTo(f.apply(t2));
    }

    default Comparator<T> thenComparing(Comparator<T> comparator) {
        return (t1, t2) -> compare(t1, t2) == 0
                ? comparator.compare(t1, t2)
                : compare(t1, t2);
    }

    default Comparator<T> thenComparing(Function<T, Comparable> f) {
        Comparator<T> comparator = comparing(f);
        return thenComparing(comparator);
    }
}
