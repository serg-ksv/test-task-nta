package com.ksv.springboottask.security.impl;

import com.ksv.springboottask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = userService.getByLogin(login);
        UserBuilder builder;
        if (user != null) {
            builder = User.withUsername(login);
            builder.password(user.getPassword());
            String[] roles = user.getRoles().stream()
                    .map(role -> role.getName().toString())
                    .toArray(String[]::new);
            builder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
