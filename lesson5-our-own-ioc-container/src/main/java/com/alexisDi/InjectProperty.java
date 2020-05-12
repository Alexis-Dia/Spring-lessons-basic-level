package com.alexisDi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Alexey Druzik on 5/12/2020
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
