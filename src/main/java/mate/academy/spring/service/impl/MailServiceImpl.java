package mate.academy.spring.service.impl;

import mate.academy.spring.model.user.User;
import mate.academy.spring.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void notify(User user) {
        mailSender.send(registrationEmail(user));
    }

    private SimpleMailMessage registrationEmail(User user) {
        String token = "myDemoToken";

        SimpleMailMessage msg = new  SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setSubject("Email registration");
        msg.setText(String.format("Please follow link http://localhost:8080/activation/%s", token));

        return msg;
    }
}
