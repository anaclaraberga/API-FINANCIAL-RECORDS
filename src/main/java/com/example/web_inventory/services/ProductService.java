package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.entities.SupplierEntity;
import com.example.web_inventory.enums.TransactionType;
import com.example.web_inventory.interfaces.ProductInterface;
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

    @Autowired
    private TransactionService transactionService;

    public ProductEntity createProduct(ProductRequestDTO dto) {
        SupplierEntity supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found."));

        ProductEntity entity = new ProductEntity(dto);
        entity.setSupplierId(supplier);

        ProductEntity created = repository.save(entity);

        TransactionRequestDTO transaction = TransactionRequestDTO.fromProduct(entity);
        transaction.setType(TransactionType.ENTRADA);

        transactionService.createTransaction(transaction);

        return created;
    }

    public ProductEntity findProductById(Long id) {
        Optional<ProductEntity> product = this.repository.findById(id);

        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado! Id: " + id + "Tipo: " + ProductEntity.class.getName(), product));
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public List<ProductInterface> getStock() {
        return repository.getStock();
    }

    public List<ProductEntity> getProductByName(String name) {
        return repository.findByName(name);
    }

    public List<ProductEntity> getProductBySupplierId(Long id) {
        return repository.findBySupplierId(id);
    }

    // public List<ProductEntity> getProductByPrice(BigInteger price) {
    // return repository.findByPrice(price);
    // }

    public ProductEntity updateProductById(ProductRequestDTO dto, Long id) {
        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        ProductEntity updated = repository.save(product);
        return updated;
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
                .map(delete -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
