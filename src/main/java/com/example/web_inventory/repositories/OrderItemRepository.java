package com.example.web_inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web_inventory.entities.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long>{
    
}
