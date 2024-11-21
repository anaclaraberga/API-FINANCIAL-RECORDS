package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.OrderRequestDTO;
import com.example.web_inventory.dtos.response.OrderResponseDTO;
import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.entities.OrderItemEntity;
import com.example.web_inventory.services.OrderItemService;
import com.example.web_inventory.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO dto) {

        OrderEntity order = orderService.createOrder(dto);

        return ResponseEntity.status(201).body(new OrderResponseDTO(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> findOrderById(@PathVariable Long id) {

        OrderEntity entity = this.orderService.findOrderById(id);

        List<OrderItemEntity> orderItems = this.orderItemService.findByOrderId(id);

        OrderResponseDTO dto = new OrderResponseDTO(entity);
        dto.setItems(orderItems);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> getAllOrders() {

        List<OrderEntity> order = orderService.getAllOrders();

        return order;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderEntity> updateOrderById(@PathVariable (value = "id") Long id, @RequestBody OrderRequestDTO dto) {

        return orderService.updateOrderById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable("id") Long id) {

        return orderService.deleteById(id);
    }
}


