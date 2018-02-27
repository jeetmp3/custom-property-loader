package demo.spring.cutom.prop.custompropertyloader.config;

import demo.spring.cutom.prop.custompropertyloader.service.RawBean;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class EnvPostProcessInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C applicationContext) {
        RawBean rawBean = applicationContext.getBean(RawBean.class);

        System.out.println("******************************************************");
        System.out.println("             Entered in ApplicationContextInitializer");
        configure(applicationContext.getEnvironment());
        System.out.println("******************************************************");

        System.out.println(rawBean);
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
