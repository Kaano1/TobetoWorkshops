package com.tobeto.spring.b.services.dtos.response.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private String modelName;
    private int modelYear;
}
