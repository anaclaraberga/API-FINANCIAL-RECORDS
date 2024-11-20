package com.example.web_inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.entities.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long>{
    List<OrderItemEntity> findByOrderId(OrderEntity orderId);
}
