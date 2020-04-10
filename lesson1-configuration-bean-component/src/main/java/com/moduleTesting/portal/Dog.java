package com.moduleTesting.portal;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog {
    private String name="dog - hnjkj";

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
