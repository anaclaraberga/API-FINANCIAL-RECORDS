package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;
import java.util.List;

import com.example.web_inventory.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private Long customerId;
    private Status status;
    private BigDecimal totalValue;
    private List<OrderItemRequestDTO> items;
}
