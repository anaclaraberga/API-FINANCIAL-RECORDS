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

import com.example.web_inventory.dtos.request.OrderItemRequestDTO;
import com.example.web_inventory.dtos.response.OrderItemResponseDTO;
import com.example.web_inventory.entities.OrderItemEntity;
import com.example.web_inventory.services.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order-item")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderItemController {
    
    @Autowired
    OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {

        this.orderItemService = orderItemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderItemResponseDTO> createOrderItem(@RequestBody OrderItemRequestDTO dto) {

        OrderItemEntity orderItem = orderItemService.createOrderItem(dto);

        return ResponseEntity.status(201).body(new OrderItemResponseDTO(orderItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemEntity> findOrderItemById(@PathVariable Long id) {

        OrderItemEntity entity = this.orderItemService.findOrderItemById(id);

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemEntity> getAllOrderItems() {

        List<OrderItemEntity> orderItem = orderItemService.getAllOrderItems();

        return orderItem;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderItemEntity> updateOrderItemById(@PathVariable(value = "id") Long id, @RequestBody OrderItemRequestDTO dto) {

        return orderItemService.updateOrderItemById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrderItemById(@PathVariable("id") Long id) {

        return orderItemService.deleteById(id);
    }
}