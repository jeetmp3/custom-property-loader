package demo.spring.cutom.prop.custompropertyloader.config;

import demo.spring.cutom.prop.custompropertyloader.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CustomConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${app.name}")
    private String name;

    private void configure() {
        Map<String, Object> map = new HashMap<>();
        map.put("app.name", "CUSTOM MAP");
        map.put("custom.property.value", "This is custom message generated from MAP");
        environment.getPropertySources().addFirst(
                new MapPropertySource("MAP", map)
        );
    }

    @EventListener(ContextStartedEvent.class)
    public void handle(ApplicationEvent event) {
        configure();
        System.out.println("----------------------------------------------------------------");
        System.out.println("         Application Prepared Event : "+event.toString());
        System.out.println("----------------------------------------------------------------");
    }

    @PostConstruct
    public void run() {
        System.out.println("================================================================");
        System.out.println("Started......");
        configure();
    }

    @Bean
    public DemoService demoService() {
        return new DemoService(name);
    }
}
