package com.alexisDi;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author Alexey Druzik on 5/12/2020
 * This is an analog of the Spring implementation of the BeanPostProcessor interface, which the user writes to create their
 *     own custom annotations. In this case, just look for a custom annotation of the Inject Property, and if there is one,
 *     then the bin is being re-configured.
 * Это аналог реализации Spring-интерфейса BeanPostProcessor, которые пишет пользователь, для создания своих
 *     собственных аннотаций. В данном случает просто ищется собственная аннотация InjectProperty, и если она есть, то
 *     происходит донастройка бина.
 */
public class InjectPropertyAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfiguratorImpl() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], (arr -> arr[1])));

    }

    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            if (annotation != null) {
                String value = annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : annotation.value();
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
