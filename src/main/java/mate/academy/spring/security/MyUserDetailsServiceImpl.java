package mate.academy.spring.security;

import lombok.extern.log4j.Log4j2;
import mate.academy.spring.model.user.User;
import mate.academy.spring.repository.UserRepository;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("start authorization!");
        User user = userService.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User not found!");

        Set<GrantedAuthority> authoritySet = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        authoritySet.add(authority);
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authoritySet);
    }
}
