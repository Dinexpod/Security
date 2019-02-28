package mate.academy.spring.service;

import mate.academy.spring.dto.UserRegistrationInput;
import mate.academy.spring.model.user.User;

public interface UserService {

    User findByUsername(String username);

    void add(UserRegistrationInput userRegistrationInput);
}
