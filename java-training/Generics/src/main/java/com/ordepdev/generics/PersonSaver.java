package com.ordepdev.generics;

import java.util.List;

public class PersonSaver {

    //public List<Person> saveAll(final List<Person> persons) {
    // Upper Bounded Wildcard
    public <T extends Person> List<T> saveAll(final List<T> persons) {

        for (Person person: persons) {
            this.savePerson(person);
        }

        return persons;
    }

    public Person[] saveAll(Person[] persons) {

        for (Person person: persons) {
            this.savePerson(person);
        }

        return persons;
    }

    private void savePerson(Person person) {
        // save the person
    }
}
