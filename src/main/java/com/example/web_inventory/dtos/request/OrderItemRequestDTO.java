package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDTO {
    
    private Long orderId;
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be a positive integer")
    private Integer quantity;

    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be a positive BigDecimal")
    private BigDecimal unitPrice;
}