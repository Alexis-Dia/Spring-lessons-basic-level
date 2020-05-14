package com.alexisDi;

/**
 * @author Alexey Druzik on 5/14/2020
 */
public class Main {
    public static void main(String[] args) {
        CoronadDisinfector coronadDisinfector = ObjectFactory.getInstance().createObject(CoronadDisinfector.class);
        coronadDisinfector.start(new Room());
    }
}
