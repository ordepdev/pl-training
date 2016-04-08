package com.ordepdev.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WildcardsTest {

    private Partner partner1 = new Partner("Partner 1", 30);
    private Partner partner2 = new Partner("Partner 2", 25);
    private Person person1 = new Person("Person1", 20);
    private Person person2 = new Person("Person2", 22);

    private PersonSaver saver = new PersonSaver();

    @Test
    public void savesListOfPersonsWithArray() {

        Partner[] partners = new Partner[2];
        partners[0] = partner1;
        partners[1] = partner2;

        //Partner[] partners = new Partner[2];
        //Person[] persons = partners;
        //persons[0] = person1;
        //saver.saveAll(persons);
        // => java.lang.ArrayStoreException

        Person[] result = saver.saveAll(partners);

        assertEquals(partner1, result[0]);
        assertEquals(partner2, result[1]);
    }

    @Test
    public void savesListOfPersonsWithList() {
        List<Partner> persons = new ArrayList<>();
        persons.add(partner1);
        persons.add(partner2);

        //List<Partner> persons = new ArrayList<>();
        // => Partner cannot be converted to Person
        // Lists are not covariant, they are type safe.
        // After implemented Upper Bounded Wildcard, it works!
        List<? extends Person> result = saver.saveAll(persons);

        assertEquals(partner1, result.get(0));
        assertEquals(partner2, result.get(1));
    }
}
