package com.tobeto.spring.b.dtos.response.car;

import com.tobeto.spring.b.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private List<Car> cars;
}
