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

    public List<CustomerEntity> getAllCustomers() {

        return repository.findAll();
    }

    // public Optional<CustomerEntity> findCustomerById(Long id) {
    //
    //     return repository.findById(id);
    // }

    // public ResponseEntity<CustomerEntity> updateCustomerById(CustomerRequestDTO dto, Long id) {
    //     return repository.findById(id)
    //     .map(customerToUpdate -> {
    //         customerToUpdate.setName(dto.getName());
    //         customerToUpdate.setNationalRegistry(dto.getNationalRegistry());
    //         customerToUpdate.setEmail(dto.getEmail());
    //         customerToUpdate.setPhone(dto.getPhone());
    //         customerToUpdate.setZipCode(dto.getZipCode());
    //         CustomerEntity updated = repository.save(customerToUpdate);
    //         return ResponseEntity.ok().body(updated);
    //     }).orElse(ResponseEntity.notFound().build());
    // }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
            .map(customerToDelete -> {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
