package com.example.web_inventory.domain.repository;

import java.util.Optional;

import com.example.web_inventory.domain.entities.CustomerBO;

public interface ICustomerRepository {
  CustomerBO save(CustomerBO bo);
  Optional<CustomerBO> findById(Long id);
  Optional<CustomerBO> findByEmail(String email);
  void deleteById(Long id);
  CustomerBO update(CustomerBO bo);
}
