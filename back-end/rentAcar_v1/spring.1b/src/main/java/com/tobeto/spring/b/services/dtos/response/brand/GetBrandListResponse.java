package com.tobeto.spring.b.services.dtos.response.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListResponse {
    private int id;
    private String name;
}
