package com.ksv.springboottask.controller;

import com.ksv.springboottask.model.Account;
import com.ksv.springboottask.model.Role;
import com.ksv.springboottask.model.User;
import com.ksv.springboottask.service.RoleService;
import com.ksv.springboottask.service.UserService;
import java.math.BigDecimal;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectDataController {
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostConstruct
    public void init() {
        injectRoles();
        injectOwner();
    }

    private void injectRoles() {
        roleService.add(new Role(Role.RoleName.USER));
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.OWNER));
    }

    private void injectOwner() {
        var roleOwner = roleService.findByName(Role.RoleName.OWNER);
        var roleAdmin = roleService.findByName(Role.RoleName.ADMIN);
        var account = new Account().setBalance(BigDecimal.ZERO).setCurrency("UAH");
        var owner = new User()
                .setLogin("owner")
                .setPassword(passwordEncoder.encode("1234"))
                .setAccount(account)
                .setRoles(Set.of(roleOwner, roleAdmin));
        userService.add(owner);
    }
}
