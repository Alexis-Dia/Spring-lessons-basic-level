package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("To protect from covid-19, drink " + alcohol);
    }
}
