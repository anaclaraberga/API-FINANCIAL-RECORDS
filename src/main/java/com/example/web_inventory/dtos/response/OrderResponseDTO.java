package com.example.web_inventory.dtos.response;

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

    public OrderResponseDTO(OrderEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.customerId = entity.getCustomerId().getId();
        this.status = entity.getStatus();
    }
}
