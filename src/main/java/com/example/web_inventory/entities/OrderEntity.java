package com.example.web_inventory.entities;

import java.io.Serializable;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_time_at_creation")
    private DateTimeAtCreation dateTimeAtCreation;

    @Column(nullable = false)
    private CustomerEntity customer;

    @Column(nullable = false)
    private Status status;

    public OrderEntity(TransactionRequestDTO dto) {
        this.id = dto.getOrderId().id;
    }
}
