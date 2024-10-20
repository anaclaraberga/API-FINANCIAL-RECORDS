package com.example.web_inventory.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {

    private String name;
    private String nationalRegistry;
    private String phone;
    private String email;
    private String zipCode;

}
