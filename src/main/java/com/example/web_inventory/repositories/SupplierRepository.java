package com.example.web_inventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.SupplierEntity;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long>{

    @Query("SELECT s FROM SupplierEntity s WHERE s.companyName = :companyName OR s.contact = :contact")
    Optional<SupplierEntity> findByNameOrContact(String companyName, String contact);

}
