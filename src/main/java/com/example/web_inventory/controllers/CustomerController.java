package com.example.web_inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.CustomerRequestDTO;
import com.example.web_inventory.dtos.response.CustomerResponseDTO;
import com.example.web_inventory.entities.CustomerEntity;
import com.example.web_inventory.services.CustomerService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/customer")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO dto) {
        CustomerEntity customer = customerService.createCustomer(dto);

        return ResponseEntity.status(201).body(new CustomerResponseDTO(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> findCustomerById(@RequestBody CustomerEntity obj, @PathVariable Long id) {

        obj = this.customerService.findCustomerById(id);
        return ResponseEntity.ok().body(obj);
    }

    // @GetMapping("/get-all")
    // @ResponseStatus(HttpStatus.OK)
    // public List<CustomerEntity> getAllCustomers() {
    //     List<CustomerEntity> customer = customerService.getAllCustomers();
        
    //     return customer;
    // }

    // @GetMapping("/{id}")
    // @Transactional
    // public Optional<CustomerEntity> getCustomerById(@RequestBody CustomerResponseDTO dto, @PathVariable(value = "id") Long id) {

    //     return customerService.findCustomerById(id);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") Long id) {
    //     return customerService.findCustomerById(id)
    //         .map(customer -> ResponseEntity.ok(new CustomerResponseDTO(customer)))
    //         .orElse(ResponseEntity.notFound().build());
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable("id") Long id) {
        return customerService.deleteById(id);
    }

}