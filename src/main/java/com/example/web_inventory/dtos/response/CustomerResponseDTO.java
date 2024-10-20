package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.CustomerEntity;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String nationalRegistry;
    private String email;
    private String phone;
    private String zipCode;

    public CustomerResponseDTO(CustomerEntity customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.nationalRegistry = customer.getNationalRegistry();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.zipCode = customer.getZipCode();
    }
}
