package com.ordepdev.composite;

public class MenuItem extends MenuComponent {

    protected MenuItem(String name, String url) {
        super(name, url);
    }

    @Override
    public String toString() {
        return print(this);
    }
}
