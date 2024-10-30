package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.SupplierRequestDTO;
import com.example.web_inventory.entities.SupplierEntity;
import com.example.web_inventory.repositories.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    
    @Autowired
    private SupplierRepository repository;

    public SupplierEntity createSupplier(SupplierRequestDTO dto) {
        SupplierEntity entity = new SupplierEntity(dto);

        return repository.save(entity);
    }

    public SupplierEntity findSupplierById(Long id) {
        Optional<SupplierEntity> supplier = this.repository.findById(id);

        return supplier.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + "Tipo: " + SupplierEntity.class.getName(), supplier));
    }

    public List<SupplierEntity> getAllSuppliers() {

        return repository.findAll();
    }

    public ResponseEntity<SupplierEntity> updateSupplierById(SupplierRequestDTO dto, Long id) {

        return repository.findById(id)
        .map(update -> {
            update.setCompanyName(dto.getCompanyName());
            update.setContact(dto.getContact());
            update.setAddress(dto.getAddress());
            SupplierEntity updated = repository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteSupplierById(Long id) {
        return repository.findById(id)
            .map(delete -> {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
