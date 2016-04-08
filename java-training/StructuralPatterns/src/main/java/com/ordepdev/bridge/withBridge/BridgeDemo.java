package com.ordepdev.bridge.withBridge;

public class BridgeDemo {

    public static void main(String[] args) {

        Color blue = new Blue();
        Color red = new Red();

        Shape square = new Square(blue);
        Shape circle = new Circle(red);

        square.applyColor();
        circle.applyColor();
    }
}
