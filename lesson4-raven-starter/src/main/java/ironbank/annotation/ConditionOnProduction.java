package ironbank.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Alexey Druzik on 5/4/2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnProductionCondition.class)
public @interface ConditionOnProduction {
}
