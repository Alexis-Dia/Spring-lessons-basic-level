package com.spring.conditional.annotations;

import com.spring.conditional.components.OnProductionModeCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author Alexey Druzik on 01.12.2020
 */
@Target({TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnProductionModeCondition.class)
public @interface ProductionMode {
    boolean value();
}