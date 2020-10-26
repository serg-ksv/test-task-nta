package com.ksv.springboottask.service.impl;

import com.ksv.springboottask.model.Order;
import com.ksv.springboottask.repository.OrderRepository;
import com.ksv.springboottask.service.OrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order findByIdAndUserLogin(Long id, String login) {
        return repository.findOrderByIdAndUser_Login(id, login);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }

    @Override
    public Order delete(Order order) {
        repository.delete(order);
        return order;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
