package com.example.web_inventory.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private LocalDateTime dateTimeAtCreation;
    private Long customerId;
    private Status status;
    private BigDecimal totalValue;

    public OrderResponseDTO(OrderEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.customerId = entity.getCustomerId().getId();
        this.status = entity.getStatus();
        this.totalValue = entity.getTotalValue();
    }
}
