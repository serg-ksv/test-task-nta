package com.ksv.springboottask.service;

import com.ksv.springboottask.model.Order;
import java.util.List;

public interface OrderService {
    Order create(Order order);

    Order get(Long id);

    List<Order> getAll();

    Order findByIdAndUserLogin(Long id, String login);

    Order update(Order order);

    Order delete(Order order);

    void deleteAll();
}
