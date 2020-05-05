package ironbank;

import ironbank.annotation.ConditionOnProduction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author Alexey Druzik on 5/2/2020
 */
/* When we are using spring.factories - it's not necessary use @Configuration*/
//@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class IronConfiguration {

    @Bean
    @ConditionOnProduction
    @ConditionalOnProperty("raven.destination")
    public RavenListener ravenListener(RavenProperties ravenProperties) {
        return new RavenListener(ravenProperties);
    }
}
