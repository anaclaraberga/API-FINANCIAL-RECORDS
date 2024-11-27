package com.example.web_inventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

    @Query("SELECT c FROM CustomerEntity c WHERE c.name = :name OR c.nationalRegistry = :nationalRegistry")
    Optional<CustomerEntity> findByNameOrCpf(String name, String nationalRegistry);
}