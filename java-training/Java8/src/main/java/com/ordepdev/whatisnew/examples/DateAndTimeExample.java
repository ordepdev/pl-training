package com.ordepdev.whatisnew.examples;

import com.ordepdev.whatisnew.Person;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateAndTimeExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("p1", 20).setDateOfBirth(LocalDate.of(1991,11,29)));
        persons.add(new Person("p2", 18).setDateOfBirth(LocalDate.of(1990,8,12)));
        persons.add(new Person("p3", 25).setDateOfBirth(LocalDate.of(1989,12,17)));
        persons.add(new Person("p4", 25).setDateOfBirth(LocalDate.of(1993,5,30)));

        LocalDate now = LocalDate.now();

        persons.stream()
                .forEach(x -> {
                    Period period = Period.between(x.getDateOfBirth(), now);
                    System.out.println(x.getName() + " was born " +
                        period.get(ChronoUnit.YEARS) + " years, " +
                        period.get(ChronoUnit.MONTHS) + " months and " +
                        period.get(ChronoUnit.DAYS) + " days ago.");
                });

        ZonedDateTime meetingLondon = ZonedDateTime.of(
                LocalDate.of(2016, Month.APRIL, 6),
                LocalTime.of(12, 00),
                ZoneId.of("Europe/London")
        );
        System.out.println("Meeting London (ISO): " + DateTimeFormatter.ISO_DATE_TIME.format(meetingLondon));
        System.out.println("Meeting London (RFC): " + DateTimeFormatter.RFC_1123_DATE_TIME.format(meetingLondon));

        ZonedDateTime meetingUS = meetingLondon.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println("Meeting US Central (ISO): " + DateTimeFormatter.ISO_DATE_TIME.format(meetingUS));
        System.out.println("Meeting US Central (RFC): " + DateTimeFormatter.RFC_1123_DATE_TIME.format(meetingUS));

        // Bridges between the APIs
        Instant instant = meetingLondon.toInstant();
        Date date = Date.from(instant);
        Instant instant1 = date.toInstant();
    }
}
