package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.SupplierEntity;

import lombok.Data;

@Data
public class SupplierResponseDTO {
    
    private Long id;
    private String companyName;
    private String cnpj;
    private String category;

    public SupplierResponseDTO(SupplierEntity entity) {
        this.id = entity.getId();
        this.companyName = entity.getCompanyName();
        this.cnpj = entity.getCnpj();
        this.category = entity.getCategory();
    }
}
