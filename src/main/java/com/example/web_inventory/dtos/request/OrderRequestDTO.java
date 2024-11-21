package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;
import java.util.List;

import com.example.web_inventory.enums.Status;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

    @NotNull
    private Long customerId;

    @NotNull
    private Status status;
    
    @Positive(message = "The total value must be a positive integer")
    private BigDecimal totalValue;

    private List<OrderItemRequestDTO> items;
}
