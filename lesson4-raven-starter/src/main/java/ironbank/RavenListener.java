package ironbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * This example shows, that in IronConfiguration-class when we use RavenListener with @Bean,
 * Spring automatically set value of ravenProperties-bean through argument of ravenListener-method
 * Here Juergen Hoeller advices to set @Autowired for better understating it.
 * Update from 19.08.2020 - аннотация @Autowired может работать над полем, по крайней мере в двух режимах:
 *     1. Когда есть интерфейс и есть имплементация(спрингу сказано в каких папках искть при старте контекста)
 *     2. Когда мы в юзаем аннотацию @EnableConfigurationProperties(RavenProperties.class), т е мы потом в других классах можем юзать:
 *         @Autowired RavenProperties ravenProperties
 * @author Alexey Druzik on 5/2/2020
 */
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Update from 19.08.2020 - It's Eugene Borisov's way.
     *     В этом случае бин RavenListener будет создан с помощью рефлексии. Т е Spring сам вызовет данный пустой конструктор:
     */
    public RavenListener() {
    }
    @Autowired
    private RavenProperties ravenProperties;

    /**
     * Update from 19.08.2020 - It's official Spring way.
     *     В этом случае бин RavenListener будет создан не с помощью рефлексии, а вручную нами. Так же в этом случае в
     *     документации рекомендуется ставить аннотацию @Autowired, что бы было понятнее. Так же в этом способе нужно
     *     юзать филд - private final RavenProperties ravenProperties;
     */
    @Autowired
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
