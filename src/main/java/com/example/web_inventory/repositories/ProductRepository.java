package com.example.web_inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.interfaces.ProductInterface;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

    @Query("SELECT p FROM ProductEntity p WHERE p.supplierId.id = :id")
    List<ProductEntity> findBySupplierId(Long id);

    @Query("SELECT p.name AS name, p.quantity AS quantity FROM ProductEntity p")
    List<ProductInterface> getStock();

    // List<ProductEntity> findByPrice(BigInteger price);

    List<ProductEntity> findByName(String name);

}
