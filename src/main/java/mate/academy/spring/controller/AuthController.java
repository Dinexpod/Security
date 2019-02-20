package mate.academy.spring.controller;

import mate.academy.spring.dto.UserRegistrationInput;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/registration")
    public String registrationGet() {
        return "registration/registration";
    }

    @PostMapping(value = "/registration")
    public String registrationPost(UserRegistrationInput userRI) {
        System.out.println(userRI.toString());
        userService.add(userRI);
        return "registration/login";
    }

//    @PostMapping(value = "/registration")
//    @ResponseBody
//    public HttpStatus registrationJson(@RequestBody UserRegistrationInput user) {
////        System.out.println("POOOOOOOOOOOOOOOOOOST");
////        userService.add(userRI);
//        return HttpStatus.OK;
//    }
//
//    @GetMapping(value = "/registration")
//    public String registrationGet() {
//        return "registration/test";
//    }

    @GetMapping(value = "/login")
    public String login() {
        return "registration/login";
    }
}
