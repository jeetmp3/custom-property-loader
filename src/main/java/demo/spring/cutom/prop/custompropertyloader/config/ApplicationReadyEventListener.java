package demo.spring.cutom.prop.custompropertyloader.config;

import demo.spring.cutom.prop.custompropertyloader.service.RawBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        RawBean rawBean = applicationContext.getBean(RawBean.class);

        System.out.println("******************************************************");
        System.out.println("             Entered in ApplicationReadyEvent Handler");
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
