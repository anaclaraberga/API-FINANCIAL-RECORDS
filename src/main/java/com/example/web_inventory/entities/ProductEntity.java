package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.web_inventory.dtos.request.ProductRequestDTO;

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

@Table(name="products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "suppliers_id")
    private SupplierEntity supplierId;
    
    public ProductEntity(ProductRequestDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
        this.image = dto.getImage().getOriginalFilename();
    }
}
