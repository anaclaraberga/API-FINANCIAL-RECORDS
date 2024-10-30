package com.example.web_inventory.entities;

import java.io.Serializable;

import com.example.web_inventory.dtos.request.SupplierRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "suppliers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 355, name = "company_name")
    private String companyName;

    @Column(nullable = false, length = 14)
    private String contact;

    @Column(nullable = false)
    private String address;

    public SupplierEntity(SupplierRequestDTO dto) {
        this.companyName = dto.getCompanyName();
        this.contact = dto.getContact();
        this.address = dto.getAddress();
    }
}
