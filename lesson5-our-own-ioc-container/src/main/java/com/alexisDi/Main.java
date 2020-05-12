package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class Main {
    public static void main(String[] args) {
        CoronadDisinfector coronadDisinfector = new CoronadDisinfector();
        coronadDisinfector.start(new Room());
    }
}
