package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;

import com.example.web_inventory.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    
    private Long customerId;
    private String status;
    private BigDecimal totalValue;

    public Status getStatus() {
        return Status.valueOf(this.status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
