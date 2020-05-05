package ironbank;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author Alexey Druzik on 5/5/2020
 */
@ConfigurationProperties("raven")
public class RavenProperties {
    List<String> destination;

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }
}
