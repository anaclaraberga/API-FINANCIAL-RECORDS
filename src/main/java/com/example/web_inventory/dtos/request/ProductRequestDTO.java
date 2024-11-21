package com.example.web_inventory.dtos.request;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    @NotNull(message = "Name is required")
    private String name;

    @NotNull
    @Size(max = 400)
    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be a positive integer")
    private Integer quantity;
    
    private MultipartFile image;

    @NotNull(message = "SupplierId is required")
    private Long supplierId;
}
