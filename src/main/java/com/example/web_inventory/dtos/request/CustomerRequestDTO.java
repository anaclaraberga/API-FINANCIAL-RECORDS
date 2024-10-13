package com.example.web_inventory.dtos.request;

import com.example.web_inventory.entities.Customer;

public record CustomerRequestDTO(Long id, String name, String phone, String email) {
    
    public CustomerRequestDTO(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail());
    }
}
