package com.ksv.springboottask.service.impl;

import com.ksv.springboottask.model.Role;
import com.ksv.springboottask.repository.RoleRepository;
import com.ksv.springboottask.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role add(Role role) {
        return repository.save(role);
    }

    @Override
    public Role findByName(Role.RoleName name) {
        return repository.findByName(name);
    }
}
