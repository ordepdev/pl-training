package com.ordepdev.generics.examples;

import com.ordepdev.generics.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {

    public static void main(String[] args) {

        Person person1 = new Person("Person 1", 20);
        Person person2 = new Person("Person 2", 30);
        Person person3 = new Person("Person 3", 40);

        Map<String, Person> persons = new HashMap<>();
        persons.put(person1.getName(), person1);
        persons.put(person2.getName(), person2);
        persons.put(person3.getName(), person3);

        System.out.println(persons);
        System.out.println(persons.size());
        System.out.println(persons.containsKey(person1.getName()));

        for (String person : persons.keySet()) {
            System.out.println(person);
        }

        for (Person person : persons.values()) {
            System.out.println(person);
        }

        for (Map.Entry<String, Person> entry: persons.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
