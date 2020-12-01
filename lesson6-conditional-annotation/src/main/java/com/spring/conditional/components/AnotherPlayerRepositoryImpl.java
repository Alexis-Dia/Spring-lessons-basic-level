package com.spring.conditional.components;

import com.spring.conditional.annotations.ProductionMode;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Druzik on 01.12.2020
 */
@Component
@ProductionMode(true)
public class AnotherPlayerRepositoryImpl implements PlayerRepository {

    @Override
    public Player getPlayer() {
        Player player = new Player();
        player.setStamina(1000);
        return player;
    }
}
