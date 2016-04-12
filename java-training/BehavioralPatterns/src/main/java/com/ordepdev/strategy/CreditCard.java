package com.ordepdev.strategy;

public class CreditCard {

    private String number;
    private String date;
    private String cvv;
    private ValidationStrategy validationStrategy;

    public CreditCard(String number, String date, String cvv, ValidationStrategy validationStrategy) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.validationStrategy = validationStrategy;
    }

    public boolean isValid() {
        return validationStrategy.isValid(this);
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }
}
