package com.example.web_inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.web_inventory.entities.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long>{

    @Query("SELECT o FROM OrderItemEntity o WHERE o.orderId.id = :id")
    List<OrderItemEntity> findByOrderId(Long id);
}
