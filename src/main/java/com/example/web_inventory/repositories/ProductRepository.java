package com.example.web_inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

    @Query("SELECT p FROM ProductEntity p WHERE p.supplierId.id = :id")
    List<ProductEntity> findBySupplierId(Long id);

    // List<ProductEntity> findByPrice(BigInteger price);

    List<ProductEntity> findByName(String name);

}
