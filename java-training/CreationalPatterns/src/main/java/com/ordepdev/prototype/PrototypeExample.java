package com.ordepdev.prototype;

public class PrototypeExample {

    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Design Patterns in Java");
        System.out.println(movie);

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");
        System.out.println(anotherMovie);
    }
}
