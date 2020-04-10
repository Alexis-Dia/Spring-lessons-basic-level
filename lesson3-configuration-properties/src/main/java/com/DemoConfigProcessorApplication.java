package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Alexey Druzik on 4/10/2020
 */
@SpringBootApplication
//@EnableConfigurationProperties({AppProperties.class})
@ImportResource(value= "classpath:context.xml")
public class DemoConfigProcessorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoConfigProcessorApplication.class, args);

        AppProperties properties = context.getBean(AppProperties.class);
        String perform = properties.getService().perform(properties.getVehicle());
        System.out.println("perform: " + perform);

        System.out.println(properties.toString());
    }

}
