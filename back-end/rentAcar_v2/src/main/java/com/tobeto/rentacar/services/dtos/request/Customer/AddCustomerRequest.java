package com.tobeto.rentacar.services.dtos.request.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {
    private String nationalityId;
}
