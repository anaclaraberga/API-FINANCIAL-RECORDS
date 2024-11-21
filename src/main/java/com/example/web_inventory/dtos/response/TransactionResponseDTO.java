package com.example.web_inventory.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.web_inventory.entities.TransactionEntity;
import com.example.web_inventory.enums.TransactionType;

import lombok.Data;

@Data
public class TransactionResponseDTO {

    private Long id;
    private Long orderId;
    private Long productId;
    private LocalDateTime dateTimeAtCreation;
    private BigDecimal value;
    private TransactionType type;

    public TransactionResponseDTO(TransactionEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.value = entity.getValue();
        this.type = entity.getType();
        this.orderId = entity.getOrderId().getId();
        this.productId = entity.getProductId().getId();
    }
}