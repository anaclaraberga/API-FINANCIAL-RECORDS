package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.UserRequestDTO;
import com.example.web_inventory.dtos.response.UserResponseDTO;
import com.example.web_inventory.entities.UserEntity;
import com.example.web_inventory.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    @Autowired
    UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createUser(@RequestBody UserRequestDTO dto) {
        UserEntity entity = userService.createUser(dto);

        return ResponseEntity.status(201).body(new UserResponseDTO(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable Long id) {

        UserEntity entity = this.userService.findUserById(id);
        
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUsers() {

        List<UserEntity> entity = userService.getAllUsers();

        return entity;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserEntity> updateUserById(@PathVariable(value = "id") Long id, @RequestBody UserRequestDTO dto) {

        return userService.updateUserById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Long id) {

        return userService.deleteUserById(id);
    }
}
