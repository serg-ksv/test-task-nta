package com.ksv.springboottask.repository;

import com.ksv.springboottask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByIdAndUser_Login(Long id, String login);
}
