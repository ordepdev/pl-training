package com.ordepdev.visitor;

public class AtvPartsDisplayVisitor implements AtvPartVisitor {

    @Override
    public void visit(Oil oil) {
        System.out.println("Oil");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Wheel");
    }

    @Override
    public void visit(Fender fender) {
        System.out.println("Fender");
    }

    @Override
    public void visit(PartsOrder partsOrder) {
        System.out.println("Parts Order");
    }
}
