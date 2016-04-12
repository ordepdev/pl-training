package com.ordepdev.observer;

public class ObserverDemo {

    public static void main(String[] args) {
        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("Hello!");
        tabletClient.addMessage("Hi there!");
    }
}
