package com.ordepdev.streams.predicate;

@FunctionalInterface
public interface Predicate<T> {

    Boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    static <U> Predicate<U> isEqualTo(U other) {
        return t -> t.equals(other);
    }
}
