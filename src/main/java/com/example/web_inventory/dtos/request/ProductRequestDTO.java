package com.example.web_inventory.dtos.request;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String name;
    private String description;
    private BigInteger price;
    private int quantity;
    private String image;
    private Long supplierId;
}
