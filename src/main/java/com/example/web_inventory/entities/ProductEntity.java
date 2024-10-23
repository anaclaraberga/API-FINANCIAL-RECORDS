package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="products")
@Entity
@Data
public class ProductEntity implements Serializable {
    
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
    private String category;

    @Column(nullable = false)
    private Status status;
    
    public ProductEntity(ProductRequestDTO dto) {  
        this.dateTimeAtCreation = dto.getDateTimeAtCreation();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
        this.category = dto.getCategory();
        this.status = dto.getStatus();
    }
}
