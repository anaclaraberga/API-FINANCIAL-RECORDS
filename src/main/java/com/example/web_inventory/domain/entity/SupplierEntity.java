package com.example.web_inventory.domain.entity;

import com.example.web_inventory.domain.entity.enums.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "suppliers")
@Entity(name = "suppliers")
@Data
public class SupplierEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String cnpj;

    private Category category;

}
