package com.example.web_inventory.dtos.response;

import java.math.BigInteger;

import com.example.web_inventory.entities.ProductEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigInteger price;
    private int quantity;
    private String image;
    private Long supplierId;

    public ProductResponseDTO(ProductEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.image = entity.getImage();
        this.supplierId = entity.getSupplierId().getId();
    }
}
