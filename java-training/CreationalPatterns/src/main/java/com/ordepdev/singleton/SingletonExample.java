package com.ordepdev.singleton;

public class SingletonExample {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();

        Singleton anotherInstance = Singleton.getInstance();

        System.out.println(instance.equals(anotherInstance));
    }
}
