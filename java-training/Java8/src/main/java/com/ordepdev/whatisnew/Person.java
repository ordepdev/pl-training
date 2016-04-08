package com.ordepdev.whatisnew;

import java.time.LocalDate;

import static java.util.Objects.*;

public class Person {

    private String name;
    private int age;
    private LocalDate dateOfBirth;

    public Person(String name, int age) {
        requireNonNull(name);

        this.name = name;
        this.age = age;
    }

    public String getName() { return this.name; }

    public int getAge() { return this.age; }


    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Person setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return this.age == person.age
                && this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
