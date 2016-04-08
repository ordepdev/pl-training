package com.ordepdev.generics.examples;

import com.ordepdev.generics.Injector;
import com.ordepdev.generics.Logger;

public class ReflectionExample {

    public static void main(String[] args) {

        Injector injector = new Injector().with("Hello World");

        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
