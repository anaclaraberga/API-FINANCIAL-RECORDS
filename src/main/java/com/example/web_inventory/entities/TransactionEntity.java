package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="transactions")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrderEntity orderId;

    @OneToMany
    @JoinColumn(name = "products_id", nullable = false)
    private ProductEntity productId;

    @Column(nullable = false, name = "date_time_at_creation")
    private LocalDateTime dateTimeAtCreation;

    @Column(nullable = false)
    private BigInteger value;

    @Column(nullable = false, name = "transaction_type")
    private TransactionType transactionType;

    public TransactionEntity(TransactionRequestDTO dto) {
        this.dateTimeAtCreation = dto.getDateTimeAtCreation();
        this.value = dto.getValue();
        this.transactionType = dto.getTransactionType();
    }
}
