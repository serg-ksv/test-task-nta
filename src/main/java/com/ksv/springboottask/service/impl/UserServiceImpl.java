package com.ksv.springboottask.service.impl;

import com.ksv.springboottask.model.User;
import com.ksv.springboottask.repository.UserRepository;
import com.ksv.springboottask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }
}
