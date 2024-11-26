package com.example.web_inventory.dtos.request;

import com.example.web_inventory.enums.UserType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO  {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
    
    @NotNull
    private UserType type;
}
