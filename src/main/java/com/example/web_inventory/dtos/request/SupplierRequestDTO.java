package com.example.web_inventory.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequestDTO {
    
    private String companyName;
    private String cnpj;
    private String category;

}
