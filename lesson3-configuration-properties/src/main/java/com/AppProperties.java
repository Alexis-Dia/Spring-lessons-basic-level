package com;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;

/**
 * @author Alexey Druzik on 4/10/2020
 */
@ConfigurationProperties(prefix = "demo")
@Component
@Validated
public class AppProperties {

    private String vehicle;

    @Max(value = 999, message = "Value 'Property' should not be greater than 999")
    private Integer value;

    private DemoService service;

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public DemoService getService() {
        return service;
    }

    public void setService(DemoService service) {
        this.service = service;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyAppProperties{" +
            "\nvehicle=" + vehicle +
            "\n,service=" + service +
            "\n,value=" + value +
            '}';
    }

}

