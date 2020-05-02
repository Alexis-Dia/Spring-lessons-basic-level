package com.moduleTesting.portal;

import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Druzik on 5/1/2020
 */
@Configuration
public class MyConfigWithoutBeanAnnotation extends Husky {

    //@Autowired
    //Husky husky2;

    @Override
    public void changeName(String name){
        //System.out.println(snake2);
        this.dog.setName("Husky 2");
        //return "husky2";
    }
}
