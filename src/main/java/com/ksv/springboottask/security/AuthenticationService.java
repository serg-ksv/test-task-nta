package com.ksv.springboottask.security;

import com.ksv.springboottask.model.User;

public interface AuthenticationService {
    User register(String login, String password);
}
