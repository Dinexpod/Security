package mate.academy.spring.service.impl;

import lombok.extern.log4j.Log4j2;
import mate.academy.spring.dto.UserLoginInput;
import mate.academy.spring.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Log4j2
@Component("securityService")
public class SecurityServiceImpl implements SecurityService {

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public SecurityServiceImpl(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doLogin(UserLoginInput userLoginInput) {
        UserDetails userDetails = userDetailsService.
                loadUserByUsername(userLoginInput.getUsername());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, userLoginInput.getPassword(),
                        userDetails.getAuthorities());
        log.info("We AUTHORIZED!!!");
        Authentication authentication = authenticationManager.
                authenticate(usernamePasswordAuthenticationToken);
    }
}
