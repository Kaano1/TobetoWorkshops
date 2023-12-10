package com.tobeto.spring.b.dtos.request.address;

import com.tobeto.spring.b.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    private int id;
    private String city;
    private String country;
    private String town;
    private Customer customer;
}
