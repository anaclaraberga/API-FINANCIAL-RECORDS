package com.example.web_inventory.dtos.response;

import java.math.BigInteger;

import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.entities.TransactionEntity;
import com.example.web_inventory.enums.PaymentMethod;

import lombok.Data;

@Data
public class TransactionResponseDTO {
    
    private Long id;
    private OrderEntity orderId;
    private BigInteger amount;
    private PaymentMethod paymentMethod;

    public TransactionResponseDTO(TransactionEntity entity) {
        this.id = entity.getId();
        this.orderId = entity.getOrderId();
        this.amount = entity.getAmount();
        this.paymentMethod = entity.getPaymentMethod();
    }
}
