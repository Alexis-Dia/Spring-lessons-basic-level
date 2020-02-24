package com.moduleTesting.portal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name = "adsadasda")
    public Dog getDog(){
        return new Dog("Gera");
    }
}
