package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @Column(nullable = true, name = "date_time_at_creation")
    private LocalDateTime dateTimeAtCreation;

    @Column(nullable = false, name = "total_value")
    private BigDecimal totalValue;

    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private CustomerEntity customerId;

    @Column(nullable = false)
    private Status status;

    public LocalDateTime getDateTimeAtCreation() {

        this.dateTimeAtCreation = LocalDateTime.now();

        return dateTimeAtCreation;
    }

    public void setDateTimeAtCreation(LocalDateTime dateTimeAtCreation) {
        this.dateTimeAtCreation = dateTimeAtCreation;
    }

    public OrderEntity(OrderRequestDTO dto) {
        this.status = dto.getStatus();
        this.totalValue = dto.getTotalValue() != null ? dto.getTotalValue() : BigDecimal.ZERO;
    }
}
