package com.ordepdev.iterator;

import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {
        BikeRepository repository = new BikeRepository();

        repository.addBike("Bike 1");
        repository.addBike("Bike 2");
        repository.addBike("Bike 3");

        Iterator<String> bikeIterator = repository.iterator();

        while (bikeIterator.hasNext()) {
            System.out.println(bikeIterator.next());
        }

        for (String bike : repository) {
            System.out.println(bike);
        }
    }
}
