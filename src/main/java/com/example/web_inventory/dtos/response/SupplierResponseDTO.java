package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.SupplierEntity;

import lombok.Data;

@Data
public class SupplierResponseDTO {
    
    private Long id;
    private String companyName;
    private String contact;
    private String address;

    public SupplierResponseDTO(SupplierEntity entity) {
        this.id = entity.getId();
        this.companyName = entity.getCompanyName();
        this.contact = entity.getContact();
        this.address = entity.getAddress();
    }
}
