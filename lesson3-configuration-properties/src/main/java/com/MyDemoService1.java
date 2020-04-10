package com;

/**
 * @author Alexey Druzik on 4/10/2020
 */
public class MyDemoService1 implements DemoService {

    @Override
    public String perform(String value) {
        return "Service №1: perform routine maintenance  work on <" + value +">";
    }
}
