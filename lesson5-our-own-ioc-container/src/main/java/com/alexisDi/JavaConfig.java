package com.alexisDi;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class JavaConfig implements Config {

    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }

    /**
     * Method computeIfAbsent - will put in a Map a new value if first param ifc is absent at the collection
     */
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + "has 0 or more than one implementations, please update your config.");
            }
            return classes.iterator().next();
        });

    }
}
