package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 * This is an analog of the BeanPostProcessor Spring interface.
 * Just as BeanPostProcessor has two methods-postProcessBeforeInitialization and postProcessAfterInitialization, so
 *     in our case, for simplicity, there is a method - configure (ob).
 * Это аналог Spring-интерфейса BeanPostProcessor.
 * Как и у BeanPostProcessor'а есть два метода - postProcessBeforeInitialization и postProcessAfterInitialization, так и
 *     в нашем случае для простоты есть метод - configure(ob).
 */
public interface ObjectConfigurator {
    void configure(Object t);
}
