package com.example.web_inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web_inventory.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
 
}
