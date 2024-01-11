package com.tobeto.spring.b.services.dtos.response.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomersListResponse {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String gmail;
}
