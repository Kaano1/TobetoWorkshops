package com.tobeto.spring.b.services.dtos.response.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsListResponse {
    private int id;
    private String modelName;
    private String modelYear;
}
