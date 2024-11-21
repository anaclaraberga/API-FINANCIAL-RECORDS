package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.entities.SupplierEntity;
import com.example.web_inventory.repositories.ProductRepository;
import com.example.web_inventory.repositories.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SupplierRepository supplierRepository;

    public ProductEntity createProduct (ProductRequestDTO dto) {
        SupplierEntity supplier = supplierRepository.findById(dto.getSupplierId())
            .orElseThrow(() -> new RuntimeException("Supplier not found."));

        ProductEntity entity = new ProductEntity(dto);

        entity.setSupplierId(supplier);

        return repository.save(entity);
    }

    public ProductEntity findProductById (Long id) {
        Optional<ProductEntity> product = this.repository.findById(id);

        return product.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: " + id + "Tipo: " + ProductEntity.class.getName(), product));
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public List<ProductEntity> getProductByName(String name) {
        return repository.findByName(name);
    }

    public List<ProductEntity> getProductBySupplierId(Long id) {
        return repository.findBySupplierId(id);
    }

    // public List<ProductEntity> getProductByPrice(BigInteger price) {
    //     return repository.findByPrice(price);
    // }

    public ResponseEntity<ProductEntity> updateProductById(ProductRequestDTO dto, Long id) {
        return repository.findById(id)
        .map(update -> {
            update.setName(dto.getName());
            update.setDescription(dto.getDescription());
            update.setPrice(dto.getPrice());
            update.setQuantity(dto.getQuantity());
            // update.setImage(dto.getImage());

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
