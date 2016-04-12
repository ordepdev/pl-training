package com.ordepdev.visitor.before;

public class Wheel implements AtvPart {
    @Override
    public double calculateShipping() {
        return 12;
    }
}
