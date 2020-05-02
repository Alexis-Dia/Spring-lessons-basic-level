package com.moduleTesting.portal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Sp {

    public static void main(String[] args) {
        // создаем пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        ApplicationContext context =
            new AnnotationConfigApplicationContext("com.moduleTesting.portal");

        //Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-kesha", Parrot.class);
        Dog dog2= (Dog) context.getBean("adsadasda");
        Husky husky= (Husky) context.getBean("hysky");
        MyConfigWithoutBeanAnnotation myConfig= (MyConfigWithoutBeanAnnotation) context.getBean(MyConfigWithoutBeanAnnotation.class);
        //myConfig.changeName("uio");

        //System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
        System.out.println(dog2.getName());
    }
}
