package com.example.web_inventory.dtos.request;

import java.math.BigInteger;

import com.example.web_inventory.enums.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {

    private Long orderId;
    private Long productId;
    private BigInteger value;
    private String transactionType;

    public TransactionType getTransactionType() {
        return TransactionType.valueOf(this.transactionType);
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
