package com.ksv.springboottask.security.impl;

import com.ksv.springboottask.model.Account;
import com.ksv.springboottask.model.Role;
import com.ksv.springboottask.model.User;
import com.ksv.springboottask.security.AuthenticationService;
import com.ksv.springboottask.service.RoleService;
import com.ksv.springboottask.service.UserService;
import java.math.BigDecimal;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String login, String password) {
        var roleUser = roleService.findByName(Role.RoleName.USER);
        var account = new Account().setBalance(BigDecimal.ZERO).setCurrency("UAH");
        return userService.add(new User()
                .setLogin(login)
                .setPassword(passwordEncoder.encode(password))
                .setAccount(account)
                .setRoles(Set.of(roleUser)));
    }
}
