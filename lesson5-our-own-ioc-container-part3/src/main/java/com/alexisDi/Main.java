package com.alexisDi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Druzik on 5/14/2020
 */
public class Main {
    public static void main(String[] args) {
//        CoronadDisinfector coronadDisinfector = ObjectFactory.getInstance().createObject(CoronadDisinfector.class);
        ApplicationContext context = Application.run("com.alexisDi", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        CoronadDisinfector disinfector = context.getObject(CoronadDisinfector.class);
        disinfector.start(new Room());
    }
}
