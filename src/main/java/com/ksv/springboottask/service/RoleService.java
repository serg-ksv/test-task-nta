package com.ksv.springboottask.service;

import com.ksv.springboottask.model.Role;

public interface RoleService {
    Role add(Role role);

    Role findByName(Role.RoleName name);
}
