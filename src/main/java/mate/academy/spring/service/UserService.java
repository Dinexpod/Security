package mate.academy.spring.service;

import mate.academy.spring.model.User;

public interface UserService {

    User findByUsername(String username);
}
