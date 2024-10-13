package com.example.web_inventory.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerBO {
  private Long id;
  private String name;
  private String phone;
  private String email;

  public CustomerBO(Long id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;

    validate();
  }

  public void validate() {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Nome é obrigatório");
    }
    if (phone == null || phone.isEmpty() || phone.length() != 11) {
      throw new IllegalArgumentException("Telefone inválido");
    }
    if (email == null || email.isEmpty() || !email.contains("@")) {
      throw new IllegalArgumentException("Email inválido");
    }
  }

}
