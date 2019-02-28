package mate.academy.spring.controller;

import mate.academy.spring.dto.UserRegistrationInput;
import mate.academy.spring.service.MailService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.validation.Validator;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private MailService mailService;

    @Autowired
    public AuthController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping(value = "/registration")
    public String registrationGet() {
        return "registration/registration";
    }

    @PostMapping(value = "/registration")
    public String registrationPost(UserRegistrationInput userRI) {
        System.out.println(userRI.toString());
        userService.add(userRI);

        mailService.notify(userRI.toUser());

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
    public String login(final Authentication authentication, final ModelMap map,
                        final HttpServletRequest request) {
        if (authentication != null) {
            return "redirect:/";
        }

        return "registration/login";
    }

    @GetMapping(value = "/activation/{token}")
    public String doActivation(@PathVariable(value = "token") String token) {
        System.out.println("My token is: " + token);
        System.out.println("implement registr confirm");
        return "redirect:/";
    }
}
