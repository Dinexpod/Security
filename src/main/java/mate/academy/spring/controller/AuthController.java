package mate.academy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration/registration";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "registration/login";
    }
}
