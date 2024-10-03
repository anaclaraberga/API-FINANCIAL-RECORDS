package com.example.expense_control.domain.entity;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

public class ProductEntity {
    
    private Long userId;
    private DateTimeAtCreation dateTimeAtCreation;
    private String description;
    private BigInteger price;
    private Enum category;
    private Enum status;
    
}
