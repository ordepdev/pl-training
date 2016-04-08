package com.ordepdev.bridge;

public class Movie {

    private String classification;
    private String runtime;
    private String title;
    private String year;

    public Movie(String classification, String title, String runtime, String year) {
        this.classification = classification;
        this.runtime = runtime;
        this.title = title;
        this.year = year;
    }

    public String getClassification() {
        return classification;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
