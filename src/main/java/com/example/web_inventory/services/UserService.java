package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.UserRequestDTO;
import com.example.web_inventory.entities.UserEntity;
import com.example.web_inventory.enums.UserType;
import com.example.web_inventory.repositories.UserRepository;
import com.example.web_inventory.utils.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity createUser(UserRequestDTO dto) {
        dto.setPassword(StringUtils.hash(dto.getPassword()));

        this.repository.findByEmail(dto.getEmail()).ifPresent(user -> {
            throw new RuntimeException("User already exists");
        });

        UserEntity entity = new UserEntity(dto);

        return repository.save(entity);
    }

    public UserEntity findUserById(Long id) {
        Optional<UserEntity> user = this.repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException(
                "Usuário não encontrado! Id: " + id + "Tipo: " + UserEntity.class.getName(), user));
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public ResponseEntity<UserEntity> updateUserById(UserRequestDTO dto, Long id) {

        return repository.findById(id)
                .map(update -> {
                    update.setName(dto.getName());
                    update.setEmail(dto.getEmail());
                    update.setPassword(StringUtils.hash(dto.getPassword()));
                    update.setType(dto.getType() != null ? dto.getType() : UserType.DEFAULT);
                    UserEntity updated = repository.save(update);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteUserById(Long id) {
        return repository.findById(id)
                .map(delete -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
