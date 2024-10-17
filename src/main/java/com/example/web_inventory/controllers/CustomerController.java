package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.CustomerRequestDTO;
import com.example.web_inventory.dtos.response.CustomerResponseDTO;
import com.example.web_inventory.entities.CustomerEntity;
import com.example.web_inventory.repositories.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @CrossOrigin(origins="*", allowedHeaders="*")
    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerRequestDTO dto) {
        CustomerEntity customer = new CustomerEntity(dto);

        return repository.save(customer);
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @PutMapping("/{id}")
    @Transactional
    public List<CustomerResponseDTO> updateCustomerById(@RequestBody CustomerResponseDTO dto, @PathVariable("id") Long id) {

        return null;
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {

        List<CustomerResponseDTO> customer = repository.findAll().stream().map(CustomerResponseDTO::new).toList();

        return customer;
    }

    @CrossOrigin(origins="*", allowedHeaders="*")
    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {

        repository.deleteById(id);
    }
}