package ironbank.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Alexey Druzik on 5/4/2020
 */
public class OnProductionCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //return JOptionPane.showConfirmDialog(null, "Is it production?") == 0;
        return true;
    }
}
