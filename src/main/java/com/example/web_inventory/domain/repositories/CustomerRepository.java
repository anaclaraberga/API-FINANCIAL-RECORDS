package com.example.web_inventory.domain.repositories;

import java.util.Optional;

import com.example.web_inventory.domain.entities.CustomerBO;

public interface CustomerRepository {
  CustomerBO save(CustomerBO bo);
  Optional<CustomerBO> findById(Long id);
  Optional<CustomerBO> findByEmail(String email);
  void deleteById(Long id);
  CustomerBO update(CustomerBO bo);
}
