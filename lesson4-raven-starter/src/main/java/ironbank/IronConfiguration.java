package ironbank;

import ironbank.annotation.ConditionOnProduction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Druzik on 5/2/2020
 */
/* When we are using spring.factories - it's not necessary use @Configuration*/
@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class IronConfiguration {

    /**
        Update from 19.08.2020: У Spring есть такая фишка, что если в контексте есть бин(не важно как созданный - напрямую
        с помощью аннотации @Bean или завтоваринный @Autowire), то помимо изания над полем @Bean, мы можем эту аннотацию
        юзать и над методом, в этом случае есть фишки:
            1. Мы можем юзать в качестве аргументов этого метода другие бины, которые есть в контексте
            2. Мы можем теле метода изменять эти бины, таким образом делая настройку созданных бинов в Spring-контейнере.
     **/

    /**
     * Update from 19.08.2020 - It's Eugene Borisov's way:
     */
    @Bean
    @ConditionOnProduction
    @ConditionalOnProperty("raven.destination")
    public RavenListener ravenListener() {
        return new RavenListener();
    }

    /**
     * Update from 19.08.2020 - It's official Spring way:
     */
    @Bean
    @ConditionOnProduction
    @ConditionalOnProperty("raven.destination")
    public RavenListener ravenListener(RavenProperties ravenProperties) {
        return new RavenListener(ravenProperties);
    }
}
