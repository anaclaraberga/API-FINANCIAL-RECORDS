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

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.dtos.response.ProductResponseDTO;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO dto) {

        ProductEntity product = productService.createProduct(dto);

        return ResponseEntity.status(201).body(new ProductResponseDTO(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable Long id) {

        ProductEntity entity = this.productService.findProductById(id);

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts() {

        List<ProductEntity> product = productService.getAllProducts();
        
        return product;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductEntity> updateProductById(@PathVariable(value = "id") Long id, @RequestBody ProductRequestDTO dto) {

        return productService.updateProductById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable("id") Long id) {

        return productService.deleteById(id);
    }
}
