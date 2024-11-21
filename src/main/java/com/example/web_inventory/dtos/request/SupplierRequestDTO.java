package com.example.web_inventory.dtos.request;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequestDTO {
    @Nullable
    private String companyName;
    @Nullable
    private String contact;
    @Nullable
    private String address;
}
