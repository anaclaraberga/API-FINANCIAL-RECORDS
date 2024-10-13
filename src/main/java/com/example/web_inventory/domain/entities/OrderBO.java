package com.example.web_inventory.domain.entities;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.web_inventory.infra.entities.Customer;
import com.example.web_inventory.infra.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBO {
    private Long id;
    private DateTimeAtCreation dateTimeAtCreation;
    private Customer customer;
    private Status status;

    public OrderBO(Long id, DateTimeAtCreation dateTimeAtCreation, Customer customer, Status status) {
        this.id = id;
        this.dateTimeAtCreation = dateTimeAtCreation;
        this.customer = customer;
        this.status = status;
    
        validate();
    }

    public void validate() {
    }
}
