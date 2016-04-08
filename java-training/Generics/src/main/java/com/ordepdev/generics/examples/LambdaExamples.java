package com.ordepdev.generics.examples;

import com.ordepdev.generics.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class LambdaExamples {

    public static void main(String[] args) {
        Person person1 = new Person("Person 1", 20);
        Person person2 = new Person("Person 2", 40);
        Person person3 = new Person("Person 3", 30);

        Predicate<Person> isOlderThan25 = person -> person.getAge() > 25;
        System.out.println(isOlderThan25.test(person1));
        System.out.println(isOlderThan25.test(person2));
        System.out.println(isOlderThan25.test(person3));

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        Map<Boolean, Long> oldAndYoungPeople = people.stream()
                .collect(partitioningBy(person -> person.getAge() > 25, counting()));

        System.out.println(oldAndYoungPeople);
    }
}
