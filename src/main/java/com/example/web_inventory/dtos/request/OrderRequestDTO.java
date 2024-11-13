package com.example.web_inventory.dtos.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private LocalDateTime dateTimeAtCreation;
    private Long customerId;
    private String status;
}
