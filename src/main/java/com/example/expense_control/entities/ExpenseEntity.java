package com.example.expense_control.entities;

import java.math.BigInteger;

import javax.print.attribute.standard.DateTimeAtCreation;

public class ExpenseEntity {
    
    private Long userId;
    private DateTimeAtCreation dateTimeAtCreation;
    private String description;
    private BigInteger amount;
    private Enum category;
    private Enum paymentMethod;
}
