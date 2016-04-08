package com.ordepdev.sales;

public final class Sale {
    private String product;
    private String store;
    private int number;
    private int pricePerItem;

    public Sale(String product, String store, int number, int pricePerItem) {
        this.product = product;
        this.store = store;
        this.number = number;
        this.pricePerItem = pricePerItem;
    }

    public String getProduct() {
        return this.product;
    }

    public int getValue() {
        return this.pricePerItem;
    }

    public String getStore() {
        return this.store;
    }
}
