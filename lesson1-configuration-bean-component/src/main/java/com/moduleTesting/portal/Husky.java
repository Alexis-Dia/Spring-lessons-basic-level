package com.moduleTesting.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Druzik on 5/1/2020
 */
@Component("hysky")
public class Husky {



    public String vvv;

    @Autowired
    Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void changeName(String name) {
        this.vvv = name;
    }

}
