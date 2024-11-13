package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigInteger;

import com.example.web_inventory.dtos.request.OrderItemRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="order_items")
@Entity
@Data
public class OrderItemEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrderEntity orderId;

    @OneToMany
    @JoinColumn(name = "products_id", nullable = false)
    @Column(nullable = false)
    private ProductEntity productId;

    @Column(nullable = false, length = 5)
    private Integer quantity;

    @Column(nullable = false, length = 15)
    private BigInteger unitPrice;
    
    public OrderItemEntity(OrderItemRequestDTO dto) {
        this.quantity = dto.getQuantity();
        this.unitPrice = dto.getUnitPrice();
    }
}
