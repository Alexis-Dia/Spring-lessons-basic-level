package ironbank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Druzik on 5/2/2020
 */
@Configuration
public class IronConfiguration {

    @Bean
    public RavenListener ravenListener() {
        return new RavenListener();
    }
}
