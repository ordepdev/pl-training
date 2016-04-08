package com.ordepdev.generics.examples;

import com.ordepdev.generics.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExamples {

    public static void main(String[] args) {

        Person person1 = new Person("Person 1", 20);
        Person person2 = new Person("Person 2", 30);
        Person person3 = new Person("Person 3", 40);

        Set<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person1);

        System.out.println(persons);
        System.out.println(persons.size());
        System.out.println(persons.contains(person1));

        for (Person person: persons) {
            System.out.println(person);
        }
    }
}
