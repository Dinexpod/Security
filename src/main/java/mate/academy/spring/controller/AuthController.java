package mate.academy.spring.controller;

import mate.academy.spring.dto.UserRegistrationInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @GetMapping(value = "/registration")
    public String registrationGet() {
        return "registration/registration";
    }

    @PostMapping(value = "/registration")
    public String registrationPost(UserRegistrationInput userRI) {
        System.out.println(userRI.toString());
        return "registration/login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "registration/login";
    }
}
