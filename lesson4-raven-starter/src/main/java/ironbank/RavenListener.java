package ironbank;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Alexey Druzik on 5/2/2020
 */
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    private final RavenProperties ravenProperties;

    public RavenListener(RavenProperties ravenProperties) {
        this.ravenProperties = ravenProperties;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ravenProperties.getDestination().forEach(destination -> {
            System.out.println("Send raven to " + destination);
        });
    }
}
