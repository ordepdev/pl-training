package com.ordepdev.visitor.before;

/**
 * Created by pedrotavares on 12/04/16.
 */
public class Oil implements AtvPart {
    @Override
    public double calculateShipping() {
        return 9;
    }
}
