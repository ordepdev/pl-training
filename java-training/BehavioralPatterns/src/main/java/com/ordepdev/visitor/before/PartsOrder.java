package com.ordepdev.visitor.before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsOrder implements AtvPart {

    private List<AtvPart> parts = new ArrayList<>();

    public void addPart(AtvPart atvPart) {
        parts.add(atvPart);
    }

    public List<AtvPart> getParts() {
        return Collections.unmodifiableList(parts);
    }

    public double calculateShipping() {
        double shippingCost = 0;
        for (AtvPart atvPAr : parts) {
            shippingCost += atvPAr.calculateShipping();
        }
        return shippingCost;
    }
}
