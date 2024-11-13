package com.example.web_inventory.dtos.response;

import java.time.LocalDateTime;

import javax.net.ssl.SSLEngineResult.Status;

import com.example.web_inventory.entities.OrderEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private LocalDateTime dateTimeAtCreation;
    private Long customerId;
    private String status;

    public Status getStatus() {

        return Status.valueOf(this.status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderResponseDTO(OrderEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.customerId = entity.getCustomerId().getId();
    }
}
