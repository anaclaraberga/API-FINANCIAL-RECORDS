package com.example.web_inventory.dtos.request;

import com.example.web_inventory.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO  {
    private String name;
    private String email;
    private String password;
    private UserType type;
}
