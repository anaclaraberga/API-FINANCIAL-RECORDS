package com.example.web_inventory.domain.entity;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.domain.entity.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "orders")
@Table(name = "orders")
@Data
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, name = "date_time_at_creation")
    private DateTimeAtCreation dateTimeAtCreation;

    @Column(nullable = false)
    private CustomerEntity customer;

    @Column(nullable = false)
    private Status status;
}
