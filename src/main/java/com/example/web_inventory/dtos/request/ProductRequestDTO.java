package com.example.web_inventory.dtos.request;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private DateTimeAtCreation dateTimeAtCreation;
    private String description;
    private BigInteger price;
    private String category;
    private String status;
}
