package com.spring.conditional;

import com.spring.conditional.components.PlayerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Druzik on 01.12.2020
 * Eugene Borisov — Spring 4.0: new generation: https://www.youtube.com/watch?v=hRtQFIVJ0ws
 * More about conditions - https://habr.com/ru/post/462541/
 */
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.spring.conditional");
        System.out.println(context.getBean(PlayerRepository.class).getPlayer().getStamina());
    }
}
