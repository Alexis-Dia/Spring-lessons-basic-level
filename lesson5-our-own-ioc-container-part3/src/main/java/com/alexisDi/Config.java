package com.alexisDi;

import org.reflections.Reflections;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public interface Config {
    Reflections getScanner();

    public <T> Class<? extends T> getImplClass(Class<T> ifc);
}
