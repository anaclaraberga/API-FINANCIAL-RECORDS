package com.example.web_inventory.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.entities.CustomerEntity;
import com.example.web_inventory.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerEntity createCustomer(CustomerEntity entity) {
        return repository.save(entity);
    }

    public List<CustomerEntity> listAllCustomers() {
        return repository.findAll();
    }

    public ResponseEntity<CustomerEntity> findCustomerById(Long id) {
        return repository.findById(id)
        .map(customer -> ResponseEntity.ok().body(customer))
        .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerEntity> updateCustomerById(CustomerEntity customer, Long id) {
        return repository.findById(id)
        .map(customerToUpdate -> {
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setNationalRegistry(customer.getNationalRegistry());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setPhone(customer.getPhone());
            customerToUpdate.setZipCode(customer.getZipCode());
            CustomerEntity updated = repository.save(customerToUpdate);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
        .map(taskToDelete -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
