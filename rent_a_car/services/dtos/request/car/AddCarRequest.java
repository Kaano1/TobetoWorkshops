package com.tobeto.spring.b.services.dtos.request.car;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private Brand brands;
}
