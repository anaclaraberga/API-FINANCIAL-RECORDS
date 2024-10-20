package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.SupplierRequestDTO;
import com.example.web_inventory.dtos.response.SupplierResponseDTO;
import com.example.web_inventory.entities.SupplierEntity;
import com.example.web_inventory.services.SupplierService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/supplier")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierController {
    
    @Autowired
    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {

        this.supplierService = supplierService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createSupplier(@RequestBody SupplierRequestDTO dto) {
        SupplierEntity entity = supplierService.createSupplier(dto);

        return ResponseEntity.status(201).body(new SupplierResponseDTO(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierEntity> findSupplierById(@PathVariable Long id) {

        SupplierEntity entity = this.supplierService.findSupplierById(id);
        
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierEntity> getAllSuppliers() {

        List<SupplierEntity> entity = supplierService.getAllSuppliers();

        return entity;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SupplierEntity> updateSupplierById(@PathVariable(value = "id") Long id, @RequestBody SupplierRequestDTO dto) {

        return supplierService.updateSupplierById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplierById(@PathVariable("id") Long id) {

        return supplierService.deleteSupplierById(id);
    }
}
