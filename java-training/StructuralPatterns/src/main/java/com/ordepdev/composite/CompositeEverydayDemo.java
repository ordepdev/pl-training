package com.ordepdev.composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeEverydayDemo {

    public static void main(String[] args) {
        Map<String, String> personAttrs = new HashMap<>();
        personAttrs.put("site_role", "person");
        personAttrs.put("access_role", "limited");

        Map<String, String> groupAttributes = new HashMap<>();
        groupAttributes.put("group_role", "claims");

        Map<String, String> secAttributes = new HashMap<>();
        secAttributes.putAll(personAttrs);
        secAttributes.putAll(groupAttributes);

        System.out.println(secAttributes);
    }
}
