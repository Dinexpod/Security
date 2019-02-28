package mate.academy.spring.service;

import mate.academy.spring.model.user.User;

public interface MailService {

    void notify(User user);
}
