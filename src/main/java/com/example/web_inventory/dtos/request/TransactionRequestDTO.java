package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;

import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.enums.TransactionType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {
    
    private Long orderId;

    private Long productId;

    @NotNull(message = "Value is required")
    @Positive(message = "Value must be a positive BigDecimal")
    private BigDecimal value;

    private TransactionType type;

    public static TransactionRequestDTO fromProduct(ProductEntity entity) {
        TransactionRequestDTO dto = new TransactionRequestDTO();
        dto.setProductId(entity.getId());
        dto.setValue(entity.getPrice());

        return dto;
    }
}
