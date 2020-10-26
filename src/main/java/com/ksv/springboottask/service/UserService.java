package com.ksv.springboottask.service;

import com.ksv.springboottask.model.User;

public interface UserService {
    User add(User user);

    User getById(Long id);

    User getByLogin(String login);

    User update(User user);
}
