package com.ordepdev.visitor;

public class AtvPartsShippingVisitor implements AtvPartVisitor {

    double shippingAmount = 0;

    @Override
    public void visit(Oil oil) {
        shippingAmount += 4;
    }

    @Override
    public void visit(Wheel wheel) {
        shippingAmount += 12;
    }

    @Override
    public void visit(Fender fender) {
        shippingAmount += 2;
    }

    @Override
    public void visit(PartsOrder partsOrder) {
        System.out.println(shippingAmount);
    }
}
