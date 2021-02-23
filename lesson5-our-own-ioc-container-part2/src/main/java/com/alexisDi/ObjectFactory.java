package com.alexisDi;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    public static ObjectFactory getInstance() {return ourInstance;}

    @SneakyThrows
    private ObjectFactory() {
        config = new JavaConfig("com.alexisDi", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        /**Here the answer to a question why it is necessary at creation of DTO-objects of entities Spring, Hibernate, etc. in a case
            creation of the own designers it is necessary to create also the empty designer, t to Spring, Hibernate
            create objects with the help of reflection, which causes an empty constructor:
         Тут ответ на вопрос, почему надо при создании DTO-объектов сущностей Spring, Hibernate и т д в случае
            создания своих собственных конструкторов надо создавать и пустой конструктор, т к Spring, Hibernate
            создают объекты с помощью рефлексии, которая и вызывает пустой конструктор:**/
        final T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t));

        return t;
    }
}
