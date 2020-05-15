package com.alexisDi;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Alexey Druzik on 5/14/2020
 */
public class InjectByTypeAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                final Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
