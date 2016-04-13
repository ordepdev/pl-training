package com.ordepdev.runnable;

public class FirstRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("I am running in thread " + name);
        };

        Thread thread = new Thread(runnable);
        thread.setName("My thread");

        thread.start();
    }
}
