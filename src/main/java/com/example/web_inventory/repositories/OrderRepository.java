package com.example.web_inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_inventory.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

    @Query("SELECT o FROM OrderEntity o WHERE o.customerId.id = :id")
    List<OrderEntity> findByCustomerId(Long id);
}
