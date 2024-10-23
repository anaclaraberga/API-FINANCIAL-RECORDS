package com.example.web_inventory.dtos.response;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private DateTimeAtCreation dateTimeAtCreation;
    private String description;
    private BigInteger price;
    private String category;
    private Status status;

    public ProductResponseDTO(ProductEntity entity) {
        this.id = entity.getId();
        this.dateTimeAtCreation = entity.getDateTimeAtCreation();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.category = entity.getCategory();
        this.status = entity.getStatus();
    }
}
