package com.tobeto.spring.b.dtos.request.brand;

import com.tobeto.spring.b.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBrandRequest {
    private int id;
    private String name;
    private List<Car> cars;
}
