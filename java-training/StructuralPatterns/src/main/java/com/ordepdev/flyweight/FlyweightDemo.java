package com.ordepdev.flyweight;

public class FlyweightDemo {

    public static void main(String[] args) {
        InventorySystem ims = new InventorySystem();

        ims.takeOrder("Razer Mouse", 221);
        ims.takeOrder("MacBook Air", 361);
        ims.takeOrder("LG 22 Monitor", 200);
        ims.takeOrder("Razer Mouse", 231);
        ims.takeOrder("MacBook Air", 311);
        ims.takeOrder("LG 22 Monitor", 500);
        ims.takeOrder("Razer Mouse", 232);
        ims.takeOrder("MacBook Air", 301);
        ims.takeOrder("LG 22 Monitor", 290);

        ims.process();

        System.out.println(ims.report());
    }
}
