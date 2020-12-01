package com.spring.conditional.components;

import com.spring.conditional.annotations.ProductionMode;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Druzik on 01.12.2020
 */
@Component
@ProductionMode(false)
public class PlayerRepositoryImpl implements PlayerRepository {

    @Override
    public Player getPlayer() {
        Player player = new Player();
        player.setStamina(98);
        return player;
    }
}
