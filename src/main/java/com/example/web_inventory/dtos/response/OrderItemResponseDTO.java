package com.example.web_inventory.dtos.response;

import java.math.BigInteger;

import com.example.web_inventory.entities.OrderItemEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponseDTO {
    
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigInteger unitPrice;

    public OrderItemResponseDTO(OrderItemEntity orderItem) {
        this.id = orderItem.getId();
        this.orderId = orderItem.getOrderId().getId();
        this.productId = orderItem.getProductId().getId();
        this.quantity = orderItem.getQuantity();
        this.unitPrice = orderItem.getUnitPrice();
    }
}
