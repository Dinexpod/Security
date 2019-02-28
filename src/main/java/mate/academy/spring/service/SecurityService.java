package mate.academy.spring.service;

import mate.academy.spring.dto.UserLoginInput;

public interface SecurityService {
    void doLogin(UserLoginInput userLoginInput);

}
