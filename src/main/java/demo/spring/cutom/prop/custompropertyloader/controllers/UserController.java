package demo.spring.cutom.prop.custompropertyloader.controllers;

import demo.spring.cutom.prop.custompropertyloader.service.DemoService;
import demo.spring.cutom.prop.custompropertyloader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DemoService demoService;

    @RequestMapping("/welcome")
    public String welcomeMessage() {
        return String.join("-", userService.getTextMessage(), demoService.getName());
    }
}
