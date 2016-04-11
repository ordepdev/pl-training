package com.ordepdev.composite;

public class CompositeDemo {

    public static void main(String[] args) {

        Menu mainMenu = new Menu("Main", "/main");
        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");

        mainMenu.add(safetyMenuItem);

        Menu claimsSubMenu = new Menu("Claims", "/claims");
        mainMenu.add(claimsSubMenu);

        MenuItem personalClaimsMenu = new MenuItem("Personal Claims", "/personalClaims");
        claimsSubMenu.add(personalClaimsMenu);

        MenuItem anotherClaimsMenuItem = new MenuItem("Another Claims", "/anotherClaims");
        //personalClaimsMenu.add(anotherClaimsMenuItem); // => UnsupportedOperationException
        ExtendableMenuItem extendableMenuItem = new ExtendableMenuItem("Extendable Claims", "/extendableClaims");
        extendableMenuItem.add(anotherClaimsMenuItem);
        mainMenu.add(extendableMenuItem);

        System.out.println(mainMenu.toString());
    }
}
