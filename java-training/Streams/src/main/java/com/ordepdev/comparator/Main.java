package com.ordepdev.comparator;

import com.ordepdev.Person;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Comparator<Person> comparatorAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> comparatorFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> comparatorLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Integer> functionAge = p -> p.getAge();
        Function<Person, String> functionFirstName = p -> p.getFirstName();
        Function<Person, String> functionLastName = p -> p.getLastName();

        Comparator<Person> comparatorAge1 = Comparator.comparing(Person::getAge);
        Comparator<Person> comparatorFirstName1 = Comparator.comparing(Person::getFirstName);
        Comparator<Person> comparatorLastName1 = Comparator.comparing(Person::getLastName);

        Comparator<Person> mixedComparator = comparatorAge1
                .thenComparing(comparatorFirstName)
                .thenComparing(comparatorLastName);

        Comparator<Person> mixedComparator1 = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getLastName);
    }
}
