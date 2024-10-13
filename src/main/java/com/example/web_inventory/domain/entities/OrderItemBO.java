package com.example.web_inventory.domain.entities;

import java.math.BigInteger;

import com.example.web_inventory.infra.entities.Order;
import com.example.web_inventory.infra.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemBO {
    private Long id;
    private Order order;
    private Product product;
    private Integer quantity;
    private BigInteger unitPrice;

    public OrderItemBO(Long id, Order order, Product product, Integer quantity, BigInteger unitPrice) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    
        validate();
    }

    public void validate() {
        if (quantity == null || quantity == 0) {
          throw new IllegalArgumentException("É obrigatório estabelecer uma quantidade maior que 0.");
        }
        if (unitPrice == null) {
          throw new IllegalArgumentException("O preço não pode ser nulo.");
        }
    }
}
