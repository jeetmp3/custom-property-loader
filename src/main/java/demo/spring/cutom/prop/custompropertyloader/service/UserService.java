package demo.spring.cutom.prop.custompropertyloader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${custom.property.value:}")
    private String textMessage;

    public String getTextMessage() {
        return textMessage;
    }
}
