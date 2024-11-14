package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.OrderRequestDTO;
import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    public OrderEntity createOrder(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity(dto);

        return repository.save(entity);
    }

    public OrderEntity findOrderById(Long id) {
        Optional<OrderEntity> order = this.repository.findById(id);

        return order.orElseThrow(() -> new ObjectNotFoundException(
            "Pedido não encontrado! Id: " + id + "Tipo: " + OrderEntity.class.getName(), order));
    }

    public List<OrderEntity> getAllOrders() {

        return repository.findAll();
    }

    public ResponseEntity<OrderEntity> updateOrderById(OrderRequestDTO dto, Long  id) {
        return repository.findById(id)
        .map(update -> {
            update.setDateTimeAtCreation(dto.getDateTimeAtCreation());
            update.setStatus(dto.getStatus());
            OrderEntity updated = repository.save(update);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
        .map(delete -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
