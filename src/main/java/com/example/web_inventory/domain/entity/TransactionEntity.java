package com.example.web_inventory.domain.entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="transactions")
@Entity(name="transactions")
@Data
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private OrderEntity order;

    @Column(nullable = false)
    private ProductEntity product;

    @Column(nullable = false, length = 5)
    private Integer quantity;

    @Column(nullable = false, length = 15)
    private BigInteger unitPrice;
}
