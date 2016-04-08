package com.ordepdev.whatisnew.examples;

import com.ordepdev.whatisnew.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("p1", 20).setDateOfBirth(LocalDate.of(1991,11,29)));
        persons.add(new Person("p2", 20).setDateOfBirth(LocalDate.of(1991,11,29)));
        persons.add(new Person("p3", 25).setDateOfBirth(LocalDate.of(1989,12,17)));
        persons.add(new Person("p4", 25).setDateOfBirth(LocalDate.of(1993,5,30)));

        List<Person> result = new ArrayList<>();

        persons.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(System.out::println);

        Stream.of(1,2,3,4,5)
                .filter(x -> x >= 3)
                .forEach(System.out::println);

        persons.stream()
                .peek(System.out::println)
                .filter(person -> person.getAge() > 20)
                .forEach(result::add);

        persons.stream()
                .map(person -> person.getName())
                .forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(1,2,3);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        System.out.println(list);

        list.stream()
                .flatMap(x -> x.stream())
                .distinct()
                .forEach(System.out::println);

        Integer sumOfAges = persons.stream()
                .map(x -> x.getAge())
                .reduce(0, Integer::sum);
        System.out.println("Sum of ages: " + sumOfAges);

        Optional<Integer> olderAge = persons.stream()
                .map(x -> x.getAge())
                .max(Integer::compare);

        olderAge.ifPresent(x -> System.out.println("Max age: " + x));

        String allPersonNames = persons.stream()
                .map(Person::getName)
                .collect(
                    Collectors.joining(", ")
                );
        System.out.println(allPersonNames);

        Map<Integer, Set<String>> personsGroupedByAge = persons.stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(Person::getName, toCollection(TreeSet::new))
                        )
                );

        System.out.println(personsGroupedByAge);

        Map<Integer, Long> numberOfPersonsGroupedByAge = persons.stream()
                .collect(
                    groupingBy(Person::getAge, counting())
                );

        System.out.println(numberOfPersonsGroupedByAge);

        Map<Integer, List<Person>> personsGroupedByAge1 = persons.stream()
                .collect(
                    groupingBy(Person::getAge)
                );

        System.out.println("* Map 1 *");
        Map<Integer, List<Person>> map1 = personsGroupedByAge1;
        map1.forEach(
            (age, persons1) -> System.out.println(age + " -> " + persons1)
        );

        System.out.println("* Map 2 *");
        Map<Integer, List<Person>> map2 = personsGroupedByAge1;
        map2.forEach(
                (age, persons1) -> System.out.println(age + " -> " + persons1)
        );

        map2.entrySet()
                .forEach(entry -> map1.merge(
                        entry.getKey(),
                        entry.getValue(),
                        (l1, l2) -> l1
                ));
        System.out.println(map1);

        Map<Integer, Map<LocalDate, List<Person>>> bimap = new HashMap<>();
        persons.forEach(
                person -> bimap.computeIfAbsent(
                        person.getAge(),
                        HashMap::new
                ).merge(
                        person.getDateOfBirth(),
                        new ArrayList<>(Arrays.asList(person)),
                        (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }
                )
        );
        System.out.println(bimap);

    }
}
