package com.ordepdev.composite;

import java.util.Iterator;

public class Menu extends MenuComponent {

    protected Menu(String name, String url) {
        super(name, url);
    }

    @Override
    public MenuComponent add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    @Override
    public MenuComponent remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(print(this));

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while(iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            builder.append(menuComponent.toString());
        }

        return builder.toString();
    }
}
