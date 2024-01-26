package net.chris.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

//au démarrage de l'application il va créer p1, p2, faire l'injection
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@RefreshScope
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig{
    private int p1;
    private int p2;


}
