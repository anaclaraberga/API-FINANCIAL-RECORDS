package com.example.web_inventory.infra.entities;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.infra.enums.Category;
import com.example.web_inventory.infra.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="products")
@Entity(name="products")
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_time_at_creation")
    private DateTimeAtCreation dateTimeAtCreation;

    @Column(nullable = false, length = 355)
    private String description;

    @Column(nullable = false)
    private BigInteger price;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Status status;
    
}
