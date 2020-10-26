package com.ksv.springboottask.repository;

import com.ksv.springboottask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM users u LEFT JOIN FETCH u.roles WHERE u.login = :login")
    User findByLogin(@Param("login") String login);
}
