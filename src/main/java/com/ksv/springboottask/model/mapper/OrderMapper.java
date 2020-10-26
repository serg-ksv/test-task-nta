package com.ksv.springboottask.model.mapper;

import com.ksv.springboottask.model.Order;
import com.ksv.springboottask.model.dto.OrderCreateDto;
import com.ksv.springboottask.model.dto.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order getOrderFromDto(OrderCreateDto dto) {
        return new Order()
                .setProductName(dto.getProductName())
                .setAmount(dto.getAmount());
    }

    public OrderResponseDto getDtoFromOrder(Order order) {
        return new OrderResponseDto()
                .setUserId(order.getUser().getId())
                .setId(order.getId())
                .setProductName(order.getProductName())
                .setAmount(order.getAmount());
    }
}
