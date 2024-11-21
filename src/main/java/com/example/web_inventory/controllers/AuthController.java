package com.example.web_inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.UserRequestDTO;
import com.example.web_inventory.dtos.response.UserResponseDTO;
import com.example.web_inventory.services.AuthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

  @Autowired
  private AuthService service;

  public AuthController(AuthService customerService) {
    this.service = customerService;
    }

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponseDTO> signUp(@RequestBody UserRequestDTO dto) {

    UserResponseDTO response = service.signUp(dto);

    return ResponseEntity.status(201).body(response);
  }

  @PostMapping("/signin")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponseDTO> signIn(@RequestBody UserRequestDTO dto) {

    UserResponseDTO response = service.signIn(dto);

    return ResponseEntity.status(201).body(response);
  }

}
