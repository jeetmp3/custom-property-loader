package demo.spring.cutom.prop.custompropertyloader.service;

import org.springframework.stereotype.Service;

@Service
public class RawBean {

    public String getBean() {
        return RawBean.class.getName();
    }
}
