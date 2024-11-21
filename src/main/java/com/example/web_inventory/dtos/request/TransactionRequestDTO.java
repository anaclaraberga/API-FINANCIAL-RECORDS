package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;

import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.enums.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {
    private Long orderId;
    private Long productId;
    private BigDecimal value;
    private TransactionType type;

    public static TransactionRequestDTO fromProduct(ProductEntity entity) {
        TransactionRequestDTO dto = new TransactionRequestDTO();
        dto.setProductId(entity.getId());
        dto.setValue(entity.getPrice());

        return dto;
    }
}
