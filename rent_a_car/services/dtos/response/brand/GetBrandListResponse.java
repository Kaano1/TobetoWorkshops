package com.tobeto.spring.b.services.dtos.response.brand;

import com.tobeto.spring.b.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListResponse {
    private List<Brand> names;
}
