package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.web_inventory.dtos.request.ProductRequestDTO;
import com.example.web_inventory.dtos.response.ProductResponseDTO;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.repositories.ProductRepository;
import com.example.web_inventory.services.ProductService;
import com.example.web_inventory.utils.UploadUtil;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository repository;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createProduct(@ModelAttribute ProductRequestDTO dto,
            @RequestParam("image") MultipartFile image) {

        ProductEntity product = productService.createProduct(dto);

        try {
            if (UploadUtil.UploadImage(image)) {
                product.setImage("/images/uploads/" + image.getOriginalFilename());
            }

            repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

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

    @PutMapping(path = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductEntity> updateProductById(@PathVariable(value = "id") Long id,
            @ModelAttribute ProductRequestDTO dto, @RequestParam("image") MultipartFile image) {

        ProductEntity product = productService.updateProductById(dto, id);

        try {
            if (UploadUtil.UploadImage(image)) {
                product.setImage("/images/uploads/" + image.getOriginalFilename());
            }

            repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteProductById(@PathVariable("id") Long id) {

        return productService.deleteById(id);
    }
}
