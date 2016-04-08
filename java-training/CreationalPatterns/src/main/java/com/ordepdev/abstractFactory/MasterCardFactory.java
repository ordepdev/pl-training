package com.ordepdev.abstractFactory;

public class MasterCardFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new MasterCardGoldCreditCard();
            case PLATINUM:
                return new MasterCardPlatinumCreditCard();
            default:
                return null;
        }
    }
}
