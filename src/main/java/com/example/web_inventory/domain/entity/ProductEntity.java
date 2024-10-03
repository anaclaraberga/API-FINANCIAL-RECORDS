package com.example.web_inventory.domain.entity;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.domain.entity.enums.Category;
import com.example.web_inventory.domain.entity.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name="products")
@Entity(name="products")
@Data
@EqualsAndHashCode(of="id")
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private DateTimeAtCreation dateTimeAtCreation;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigInteger price;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Status status;
    
}
