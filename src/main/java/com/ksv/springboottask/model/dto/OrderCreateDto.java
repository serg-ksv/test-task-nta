package com.ksv.springboottask.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderCreateDto {
    private String productName;
    private int amount;
}
