package com.tobeto.spring.b.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {
    private String city;
    private String country;
    private String town;
}
