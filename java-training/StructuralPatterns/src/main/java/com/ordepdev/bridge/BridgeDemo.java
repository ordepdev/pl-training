package com.ordepdev.bridge;

public class BridgeDemo {

    public static void main(String[] args) {

        Movie movie = new Movie("Action", "Action Movie 1", "2:00", "2015");

        Formatter printFormatter = new PrintFormatter();
        Formatter htmlFormatter = new HtmlFormatter();
        Printer moviePrinter = new MoviePrinter(movie);

        String printedMovie = moviePrinter.print(printFormatter);
        System.out.println(printedMovie);

        String htmlMovie = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMovie);
    }
}
