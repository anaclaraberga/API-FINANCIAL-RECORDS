package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.CustomerRequestDTO;
import com.example.web_inventory.entities.CustomerEntity;
import com.example.web_inventory.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired  
    private CustomerRepository repository;


    public CustomerEntity createCustomer(CustomerRequestDTO dto) {
        CustomerEntity entity = new CustomerEntity(dto);

        return repository.save(entity);
    }

    public CustomerEntity findCustomerById(Long id) {
        Optional<CustomerEntity> customer = this.repository.findById(id);

        return customer.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + "Tipo: " + CustomerEntity.class.getName(), customer));
    }

    public Optional<CustomerEntity> findCustomerByNameOrCpf(String name, String nationalRegistry) {
        return repository.findByNameOrCpf(name, nationalRegistry);
    }

    public List<CustomerEntity> getAllCustomers() {
        return repository.findAll();
    }

    public ResponseEntity<CustomerEntity> updateCustomerById(CustomerRequestDTO dto, Long id) {
        return repository.findById(id)
        .map( update -> {
            update.setName(dto.getName());
            update.setNationalRegistry(dto.getNationalRegistry());
            update.setEmail(dto.getEmail());
            update.setPhone(dto.getPhone());
            update.setZipCode(dto.getZipCode());
            CustomerEntity updated = repository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
            .map(delete -> {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
