package com.example.web_inventory.dtos.request;

import java.math.BigInteger;

import com.example.web_inventory.entities.OrderEntity;
import com.example.web_inventory.enums.PaymentMethod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {

    private Long orderId;
    private BigInteger amount;
    private String paymentMethod;

    public PaymentMethod getPaymentMethod() {

        return PaymentMethod.valueOf(this.paymentMethod);
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderEntity getOrderId() {

        return OrderEntity.class.cast(this.orderId);
    }

    public void setOrderId(OrderEntity order) {
        this.orderId = order.getId();
    }
}
