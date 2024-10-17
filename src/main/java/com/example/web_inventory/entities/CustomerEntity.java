package com.example.web_inventory.entities;

import com.example.web_inventory.dtos.request.CustomerRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 14, name = "cpf_cnpj")
    private String nationalRegistry;

    @Column(nullable = false, length = 11)
    private String phone;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 8, name = "cep")
    private String zipCode;

    public CustomerEntity(CustomerRequestDTO dto) {
        this.name = dto.getName();
        this.nationalRegistry = dto.getNationalRegistry();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.zipCode = dto.getZipCode();
    }
}
