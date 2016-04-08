package com.ordepdev.builder;

public class BuilderExample {

    public static void main(String[] args) {

        LunchOrder lunchOrder = new LunchOrder.Builder()
                .bread("dark")
                .condiments("letuce")
                .dressing("mayo")
                .meat("chicken")
                .build();
        System.out.println(lunchOrder);

        LunchOrder paleoLunchOrder = new LunchOrder.Builder()
                .condiments("letuce")
                .meat("chicken")
                .build();
        System.out.println(paleoLunchOrder);
    }
}
