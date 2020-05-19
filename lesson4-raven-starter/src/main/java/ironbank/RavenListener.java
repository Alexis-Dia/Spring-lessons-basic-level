package ironbank;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Alexey Druzik on 5/2/2020
 */
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    /** This example shows, that in IronConfiguration-class when we use RavenListener with @Bean,
    Spring automatically set value of ravenProperties-bean through argument of ravenListener-method
    Here Juergen Hoeller advices to set @Autowired for better understating it.
     **/
    //@Autowired
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
