package com.ordepdev.mediator;

// receiver
public class Light {

    private boolean isOn = false;
    private String light;

    public Light(String light) {
        this.light = light;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
        if (isOn) on();
        else off();
    }

    public void on() {
        System.out.println(light + " light switched on.");
    }

    public void off() {
        System.out.println(light + " light switched off.");
    }
}
