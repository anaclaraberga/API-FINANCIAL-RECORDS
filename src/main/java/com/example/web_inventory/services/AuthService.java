package com.example.web_inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.UserRequestDTO;
import com.example.web_inventory.dtos.response.UserResponseDTO;
import com.example.web_inventory.entities.UserEntity;
import com.example.web_inventory.repositories.UserRepository;
import com.example.web_inventory.utils.StringUtils;

@Service
public class AuthService {

  @Autowired
  private UserRepository repository;

  public AuthService(UserRepository repository) {
    this.repository = repository;
  }

  public UserResponseDTO signUp(UserRequestDTO dto) {
    this.repository.findByEmail(dto.getEmail()).ifPresent(user -> {
      throw new RuntimeException("User already exists");
    });

    dto.setPassword(StringUtils.hash(dto.getPassword()));

    UserEntity newUser = new UserEntity(dto);
    UserEntity created = this.repository.save(newUser);
    UserResponseDTO response = new UserResponseDTO(created);

    return response;
  }

  public UserResponseDTO signIn(UserRequestDTO dto) {
    dto.setPassword(StringUtils.hash(dto.getPassword()));

    UserEntity entity = this.repository.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
    .orElseThrow(() -> new RuntimeException("Email or password incorrect"));

    UserResponseDTO response = new UserResponseDTO(entity);

    return response;
  }


}
