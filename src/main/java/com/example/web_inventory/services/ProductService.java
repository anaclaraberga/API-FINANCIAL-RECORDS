package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductEntity createProduct (ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity(dto);

        return repository.save(entity);
    }

    public ProductEntity findProductById (Long id) {
        Optional<ProductEntity> customer = this.repository.findById(id);

        return customer.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: " + id + "Tipo: " + ProductEntity.class.getName(), customer));
    }

    public List<ProductEntity> getAllProducts() {

        return repository.findAll();
    }

    public ResponseEntity<ProductEntity> updateProductById(ProductRequestDTO dto, Long id) {
        return repository.findById(id)
        .map(update -> {
            update.setDescription(dto.getDescription());
            update.setPrice(dto.getPrice());
            update.setStatus(dto.getStatus());
            update.setCategory(dto.getCategory());

            ProductEntity updated = repository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id) {
        return repository.findById(id)
        .map(delete -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
