package com.example.web_inventory.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.web_inventory.dtos.request.OrderRequestDTO;
import com.example.web_inventory.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_time_at_creation")
    private LocalDateTime dateTimeAtCreation;

    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private CustomerEntity customerId;

    @Column(nullable = false)
    private Status status;

    public OrderEntity(OrderRequestDTO dto) {
        this.dateTimeAtCreation = dto.getDateTimeAtCreation();
        this.status = dto.getStatus();
    }
}
