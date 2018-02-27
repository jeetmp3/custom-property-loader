package demo.spring.cutom.prop.custompropertyloader.config;

import demo.spring.cutom.prop.custompropertyloader.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class EnvPostProcessor implements EnvironmentPostProcessor {

    @Autowired
    private DemoService demoService;

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("******************************************************");
        System.out.println("             Entered in Env Post Processor");
        configure(environment);
        System.out.println("******************************************************");

        System.out.println(demoService);
    }

    private void configure(ConfigurableEnvironment environment) {
        Map<String, Object> map = new HashMap<>();
        map.put("app.name", "CUSTOM MAP");
        map.put("custom.property.value", "This is custom message generated from MAP");
        environment.getPropertySources().addFirst(
                new MapPropertySource("MAP", map)
        );
    }
}
