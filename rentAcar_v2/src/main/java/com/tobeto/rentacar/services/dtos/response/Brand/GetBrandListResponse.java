package com.tobeto.rentacar.services.dtos.response.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListResponse {
    private String name;
    private String logoPath;

}
