package com.example.web_inventory.dtos.response;

import java.math.BigInteger;
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
    private BigInteger value;
    private TransactionType transactionType;

    public TransactionResponseDTO(TransactionEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.value = entity.getValue();
        this.transactionType = entity.getTransactionType();
        this.orderId = entity.getOrderId().getId();
        this.productId = entity.getProductId().getId();
    }
}