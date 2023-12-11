package com.tobeto.spring.b.services.dtos.request.address;

import com.tobeto.spring.b.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {
    private String city;
    private String country;
    private String town;
}
