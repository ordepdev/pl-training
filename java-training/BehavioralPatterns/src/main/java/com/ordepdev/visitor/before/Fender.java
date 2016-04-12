package com.ordepdev.visitor.before;

public class Fender implements AtvPart {
    @Override
    public double calculateShipping() {
        return 2;
    }
}
