package com.ksv.springboottask.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderUpdateDto {
    private Long id;
    private String productName;
    private int amount;
}
