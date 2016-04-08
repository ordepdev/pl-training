package com.ordepdev.whatisnew.examples;

public class RunnableExample {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        Thread anotherThread = new Thread(runnable);
        anotherThread.start();
        anotherThread.join();
    }
}
