package com.ksv.springboottask.controller;

import com.ksv.springboottask.model.dto.OrderResponseDto;
import com.ksv.springboottask.model.dto.OrderUpdateDto;
import com.ksv.springboottask.model.mapper.OrderMapper;
import com.ksv.springboottask.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/orders/{id}")
    public OrderResponseDto get(@PathVariable Long id) {
        var order = orderService.get(id);
        return orderMapper.getDtoFromOrder(order);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getAll() {
        return orderService.getAll()
                .stream()
                .map(orderMapper::getDtoFromOrder)
                .collect(Collectors.toList());
    }

    @PutMapping("/orders")
    public OrderResponseDto update(@RequestBody OrderUpdateDto dto) {
        var order = orderService.get(dto.getId());
        order.setAmount(dto.getAmount())
                .setProductName(dto.getProductName());
        return orderMapper.getDtoFromOrder(orderService.update(order));
    }

    @PutMapping("/orders/update-all")
    public List<OrderResponseDto> updateAll(@RequestBody List<OrderUpdateDto> dtoList) {
        return dtoList.stream()
                .map(this::update)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/orders/{id}")
    public OrderResponseDto delete(@PathVariable Long id) {
        var order = orderService.get(id);
        return orderMapper.getDtoFromOrder(orderService.delete(order));
    }

    @DeleteMapping("/orders")
    public void deleteAll() {
        orderService.deleteAll();
    }
}
