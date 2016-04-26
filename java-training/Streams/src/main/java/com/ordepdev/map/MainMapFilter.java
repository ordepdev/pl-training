package com.ordepdev.map;

import com.ordepdev.Person;

import java.util.Arrays;
import java.util.List;

public class MainMapFilter {

    public static void main(String[] args) {

        Person person1 = new Person("first name", "last name", 20);
        Person person2 = new Person("first name", "last name", 30);
        Person person3 = new Person("first name", "last name", 22);
        Person person4 = new Person("first name", "last name", 25);
        Person person5 = new Person("first name", "last name", 35);
        Person person6 = new Person("first name", "last name", 21);

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5, person6);

        Integer sum = people.stream()
                .map(Person::getAge)
                .filter(age -> age < 40)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
