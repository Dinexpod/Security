package mate.academy.spring.security;

import lombok.extern.log4j.Log4j2;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        mate.academy.spring.model.User user = userService.findByUsername(username);
        Set<GrantedAuthority> authoritySet = new HashSet<>();
        System.out.println("We AUTHORIZED!!!");
        return new org.springframework.security.core.
                userdetails.User(user.getUsername(), user.getPassword(), authoritySet);
    }
}
