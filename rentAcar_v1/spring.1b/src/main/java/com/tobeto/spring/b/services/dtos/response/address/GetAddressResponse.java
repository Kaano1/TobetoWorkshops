package com.tobeto.spring.b.services.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {
    private String town;
    private String city;
    private String country;
    private String detail;
}
