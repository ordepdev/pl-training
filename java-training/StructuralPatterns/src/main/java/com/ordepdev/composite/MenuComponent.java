package com.ordepdev.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

    protected String name;
    protected String url;
    protected List<MenuComponent> menuComponents = new ArrayList<>();


    protected MenuComponent(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public MenuComponent add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

    public abstract String toString();

    protected String print(MenuComponent menuComponent) {
        StringBuilder builder = new StringBuilder(name);

        builder.append(": ");
        builder.append(url);
        builder.append("\n");

        return builder.toString();
    }
}
