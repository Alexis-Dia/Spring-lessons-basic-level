package com.spring.conditional.components;

import com.spring.conditional.annotations.ProductionMode;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author Alexey Druzik on 01.12.2020
 */
public class OnProductionModeCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ProductionMode.class.getName());

        assert annotationAttributes != null;
        boolean productionModeRequested = (Boolean) annotationAttributes.get("value");
        boolean hasProductionMode = Boolean.parseBoolean(System.getenv().get("productionMode"));
        return productionModeRequested && hasProductionMode || !productionModeRequested && !hasProductionMode;
    }
}
