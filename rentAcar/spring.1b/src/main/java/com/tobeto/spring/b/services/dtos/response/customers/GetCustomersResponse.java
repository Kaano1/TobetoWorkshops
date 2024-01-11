package com.tobeto.spring.b.services.dtos.response.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomersResponse {
    private String name;
    private String surname;
    private String phone;
    private String gmail;
}
