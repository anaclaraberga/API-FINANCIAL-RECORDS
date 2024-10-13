package com.example.web_inventory.infra.entities;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.infra.enums.PaymentMethod;

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
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Order order;

    @Column(nullable = false, name = "date_time_at_creation")
    private DateTimeAtCreation dateTimeAtCreation;

    @Column(nullable = false)
    private BigInteger amount;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;
}
