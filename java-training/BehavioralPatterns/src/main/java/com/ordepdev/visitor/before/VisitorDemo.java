package com.ordepdev.visitor.before;

public class VisitorDemo {

    public static void main(String[] args) {
        PartsOrder order = new PartsOrder();
        order.addPart(new Wheel());
        order.addPart(new Oil());
        order.addPart(new Fender());

        double shippingCost = order.calculateShipping();
        System.out.println(shippingCost);

    }
}
