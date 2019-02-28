package mate.academy.spring.service.impl;

import mate.academy.spring.dto.UserRegistrationInput;
import mate.academy.spring.model.user.User;
import mate.academy.spring.repository.UserRepository;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void add(UserRegistrationInput userRegistrationInput) {
        String encodePass = passwordEncoder.encode(userRegistrationInput.getPassword());
        userRegistrationInput.setPassword(encodePass);
        userRepository.save(userRegistrationInput.toUser());
    }
}
