package com.ordepdev.abstractFactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(300);
        CreditCard creditCard = abstractFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(creditCard.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(100);
        CreditCard creditCard1 = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(creditCard1.getClass());
    }
}
