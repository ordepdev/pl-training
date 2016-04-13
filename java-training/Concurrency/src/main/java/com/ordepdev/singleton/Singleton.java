package com.ordepdev.singleton;

public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    private static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
