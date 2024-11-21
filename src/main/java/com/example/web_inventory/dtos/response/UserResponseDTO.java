package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.UserEntity;
import com.example.web_inventory.enums.UserType;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserType type;

    public UserResponseDTO(UserEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.type = entity.getType();
    }
}
