package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.OrderItemRequestDTO;
import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.entities.OrderItemEntity;
import com.example.web_inventory.entities.ProductEntity;
import com.example.web_inventory.repositories.OrderItemRepository;
import com.example.web_inventory.repositories.OrderRepository;
import com.example.web_inventory.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    
    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderItemEntity createOrderItem(OrderItemRequestDTO dto) {
        OrderEntity order = orderRepository.findById(dto.getOrderId())
            .orElseThrow(() -> new RuntimeException("Order not found."));

        ProductEntity product = productRepository.findById(dto.getProductId())
            .orElseThrow(() -> new RuntimeException("Product not found."));
        
        OrderItemEntity entity = new OrderItemEntity(dto);

        entity.setProductId(product);
        entity.setOrderId(order);

        return repository.save(entity);
    }

    public OrderItemEntity findOrderItemById (Long id) {
        Optional<OrderItemEntity> product = this.repository.findById(id);

        return product.orElseThrow(() -> new ObjectNotFoundException("Itens de pedido" + id + "Tipo: " + OrderItemEntity.class.getName(), product));
    }

    public List<OrderItemEntity> getAllOrderItems() {

        return repository.findAll();
    }

    public ResponseEntity<OrderItemEntity> updateOrderItemById(OrderItemRequestDTO dto, Long id) {
        return repository.findById(id)
        .map(update -> {
            update.setQuantity(dto.getQuantity());
            update.setUnitPrice(dto.getUnitPrice());

            OrderItemEntity updated = repository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id) {
        return repository.findById(id)
        .map(delete -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
