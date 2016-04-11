package com.ordepdev.command;

import java.util.ArrayList;
import java.util.List;

// client
public class CommandDemo {

    public static void main(String[] args) {
        Light light = new Light();
        Switch lightSwitch = new Switch();

        System.out.println();
        Command command = new OnCommand(light);
        lightSwitch.storeAndExecute(command);

        // add state to app
        System.out.println();
        Command toggle = new ToggleCommand(light);
        lightSwitch.storeAndExecute(toggle);
        lightSwitch.storeAndExecute(toggle);
        lightSwitch.storeAndExecute(toggle);

        // add macro to app
        System.out.println();
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();
        List<Light> lights = new ArrayList<>();
        lights.add(bedroomLight);
        lights.add(kitchenLight);

        Command toggleCommand = new ToggleCommand(kitchenLight);
        lightSwitch.storeAndExecute(toggleCommand);

        Command allLightsCommand = new AllLightsCommand(lights);
        lightSwitch.storeAndExecute(allLightsCommand);

    }
}
