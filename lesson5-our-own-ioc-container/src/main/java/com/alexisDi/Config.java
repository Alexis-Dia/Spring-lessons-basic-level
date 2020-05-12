package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public interface Config {
    public <T> Class<? extends T> getImplClass(Class<T> ifc);
}
