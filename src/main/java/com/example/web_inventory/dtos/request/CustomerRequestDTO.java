package com.example.web_inventory.dtos.request;

import com.example.web_inventory.entities.Customer;

public record CustomerRequestDTO(Long id, String name, String nationalRegistry, String phone, String email, String zipCode) {
    
    public CustomerRequestDTO(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getNationalRegistry(), customer.getPhone(), customer.getEmail(), customer.getZipCode());
    }
}
