package com.example.web_inventory.dtos.request;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDTO {
    private Long orderId;
    private Long product;
    private Integer quantity;
    private BigInteger unitPrice;
}