package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.web_inventory.dtos.request.OrderItemRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="order_items")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrderEntity orderId;

    @ManyToOne
    @JoinColumn(name = "products_id", nullable = false)
    private ProductEntity productId;

    @Column(nullable = false, length = 5)
    private Integer quantity;
    
    @Column(nullable = false, length = 15)
    private BigDecimal unitPrice;

    public OrderItemEntity(OrderItemRequestDTO dto) {
        this.quantity = dto.getQuantity();
    }

    public BigDecimal getUnitPrice() {
        this.unitPrice = productId.getPrice();
        return unitPrice;
    }
}
