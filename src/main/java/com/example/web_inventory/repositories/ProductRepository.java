package com.example.web_inventory.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

    List<ProductEntity> findBySupplier(String supplierName);

    List<ProductEntity> findByPrice(BigInteger price);

    List<ProductEntity> findByProductName(String name);
    
}
