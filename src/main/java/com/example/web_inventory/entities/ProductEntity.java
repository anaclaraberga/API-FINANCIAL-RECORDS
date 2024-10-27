package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_time_at_creation")
    private LocalDateTime dateTimeAtCreation;

    @Column(nullable = false, length = 355)
    private String description;

    @Column(nullable = false)
    private BigInteger price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Status status;
    
    public ProductEntity(ProductRequestDTO dto) {  
        this.dateTimeAtCreation = LocalDateTime.now();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
        this.category = dto.getCategory();
        this.status = dto.getStatus();
    }
}
