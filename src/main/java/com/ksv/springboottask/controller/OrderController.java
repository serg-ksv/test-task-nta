package com.ksv.springboottask.controller;

import com.ksv.springboottask.model.dto.OrderCreateDto;
import com.ksv.springboottask.model.dto.OrderResponseDto;
import com.ksv.springboottask.model.dto.OrderUpdateDto;
import com.ksv.springboottask.model.mapper.OrderMapper;
import com.ksv.springboottask.service.OrderService;
import com.ksv.springboottask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserService userService;

    @GetMapping("/{id}")
    public OrderResponseDto get(@PathVariable Long id,
                                Authentication authentication) {
        var order = orderService.findByIdAndUserLogin(id, authentication.getName());
        return orderMapper.getDtoFromOrder(order);
    }

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderCreateDto dto,
                                   Authentication authentication) {
        var user = userService.getByLogin(authentication.getName());
        var order = orderMapper.getOrderFromDto(dto);
        order.setUser(user);
        return orderMapper.getDtoFromOrder(orderService.create(order));
    }

    @PutMapping
    public OrderResponseDto update(@RequestBody OrderUpdateDto dto,
                                   Authentication authentication) {
        var order = orderService.findByIdAndUserLogin(dto.getId(), authentication.getName());
        order.setAmount(dto.getAmount())
                .setProductName(dto.getProductName());
        return orderMapper.getDtoFromOrder(orderService.update(order));
    }

    @DeleteMapping("/{id}")
    public OrderResponseDto delete(@PathVariable Long id,
                                   Authentication authentication) {
        var order = orderService.findByIdAndUserLogin(id, authentication.getName());
        return orderMapper.getDtoFromOrder(orderService.delete(order));
    }
}
