package com.ordepdev.generics.examples;

import com.ordepdev.generics.AgeComparator;
import com.ordepdev.generics.Person;
import com.ordepdev.generics.ReverseComparator;

import java.util.*;

public class ListExamples {

    public static void main(String[] args) {

        Person person1 = new Person("Person 1", 20);
        Person person2 = new Person("Person 2", 40);
        Person person3 = new Person("Person 3", 30);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        System.out.println(persons);
        System.out.println(persons.size());

        Collections.sort(persons, new AgeComparator());

        for (Person person: persons) {
            System.out.println(person);
        }

        Collections.sort(persons, new ReverseComparator<>(new AgeComparator()));

        for (Person person: persons) {
            System.out.println(person);
        }

        final Person youngestPerson = min(persons, new AgeComparator());
        System.out.println(youngestPerson);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(-1);

        final int lowestNumber = min(numbers, Integer::compare);
        System.out.println(lowestNumber);
    }

    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }

        T lowestElement = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);

            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }
}
