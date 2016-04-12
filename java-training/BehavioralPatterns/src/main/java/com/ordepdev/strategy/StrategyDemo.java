package com.ordepdev.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        CreditCard amexCard = new CreditCard("379185883464283",
                "12/2016", "123", new AmexStrategy());

        System.out.println("Is Amex valid: " + amexCard.isValid());

        CreditCard amexCard2 = new CreditCard("379185883464282",
                "12/2016", "234", new AmexStrategy());

        System.out.println("Is Amex valid: " + amexCard2.isValid());

        CreditCard visaCard = new CreditCard("4195555082144262",
                "12/2016", "818", new VisaStrategy());

        System.out.println("Is VISA valid: " + visaCard.isValid());
    }
}
