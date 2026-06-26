package edu;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class SomeComponent {
    private String name;
    private String version;
    private String description;

    public String getAppInfo() {
        return String.join(", ", name, version, description);
    }
}
