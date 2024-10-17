package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.CustomerEntity;

public record CustomerResponseDTO(Long id, String name, String nationalRegistry, String phone, String email, String zipCode) {

    public CustomerResponseDTO(CustomerEntity customer) {
        this(customer.getId(), customer.getName(), customer.getNationalRegistry(), customer.getPhone(), customer.getEmail(), customer.getZipCode());
    }
}
