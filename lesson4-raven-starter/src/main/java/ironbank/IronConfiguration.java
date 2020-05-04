package ironbank;

import ironbank.annotation.ConditionOnProduction;
import org.springframework.context.annotation.Bean;

/**
 * @author Alexey Druzik on 5/2/2020
 */
/* When we are using spring.factories - it's not necessary use @Configuration*/
//@Configuration
public class IronConfiguration {

    @Bean
    @ConditionOnProduction
    public RavenListener ravenListener() {
        return new RavenListener();
    }
}
