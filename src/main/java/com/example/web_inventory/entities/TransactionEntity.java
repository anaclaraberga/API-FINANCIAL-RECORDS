package com.example.web_inventory.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "orders_id", nullable = true)
    private OrderEntity orderId;

    @ManyToOne
    @JoinColumn(name = "products_id", nullable = false)
    private ProductEntity productId;

    @Column(nullable = false, name = "date_time_at_creation")
    private LocalDateTime dateTimeAtCreation;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false, name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public TransactionEntity(TransactionRequestDTO dto) {
        this.dateTimeAtCreation = LocalDateTime.now();
        this.value = dto.getValue();
        this.type = dto.getType();
    }
}
