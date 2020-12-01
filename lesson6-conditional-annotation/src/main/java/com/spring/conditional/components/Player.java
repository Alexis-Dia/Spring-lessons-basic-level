package com.spring.conditional.components;

import org.springframework.stereotype.Component;

/**
 * @author Alexey Druzik on 01.12.2020
 */
@Component
public class Player {

    private int stamina;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
