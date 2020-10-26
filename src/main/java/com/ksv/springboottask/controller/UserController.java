package com.ksv.springboottask.controller;

import com.ksv.springboottask.model.Role;
import com.ksv.springboottask.service.RoleService;
import com.ksv.springboottask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @PutMapping("/block/{id}")
    public ResponseEntity<String> blockUser(@PathVariable Long id) {
        var user = userService.getById(id);
        user.setBlocked(true);
        userService.update(user);
        return ResponseEntity.ok("User with id " + id + " was blocked.");
    }

    @PutMapping("/unblock/{id}")
    public ResponseEntity<String> unblockUser(@PathVariable Long id) {
        var user = userService.getById(id);
        user.setBlocked(false);
        userService.update(user);
        return ResponseEntity.ok("User with id " + id + " was unblocked.");
    }

    @PutMapping("/set-admin-rights/{id}")
    public ResponseEntity<String> addAdminRights(@PathVariable Long id) {
        var roleAdmin = roleService.findByName(Role.RoleName.ADMIN);
        var user = userService.getById(id);
        user.getRoles().add(roleAdmin);
        userService.update(user);
        return ResponseEntity.ok("Role Admin was added to User with id " + id);
    }

    @PutMapping("/remove-admin-rights/{id}")
    public ResponseEntity<String> removeAdminRights(@PathVariable Long id) {
        var user = userService.getById(id);
        user.getRoles()
                .removeIf(role -> role.getName().equals(Role.RoleName.ADMIN));
        userService.update(user);
        return ResponseEntity.ok("Role Admin was removed from User with id " + id);
    }
}
