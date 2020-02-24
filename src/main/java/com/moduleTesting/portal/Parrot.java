package com.moduleTesting.portal;

import org.springframework.stereotype.Component;

@Component("parrot-kesha")
public class Parrot {
    private String name="yrtyty";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
