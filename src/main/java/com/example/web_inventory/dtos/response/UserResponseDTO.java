package com.example.web_inventory.dtos.response;

import com.example.web_inventory.entities.UserEntity;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserResponseDTO(UserEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }
}
