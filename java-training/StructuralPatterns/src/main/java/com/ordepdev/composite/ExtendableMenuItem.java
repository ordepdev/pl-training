package com.ordepdev.composite;

/**
 * Created by pedrotavares on 11/04/16.
 */
public class ExtendableMenuItem extends  MenuComponent {

    protected ExtendableMenuItem(String name, String url) {
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
        return print(this);
    }
}
