package com.tobeto.spring.b.dtos.request.car;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {
    private int id;
    private int modelYear;
    private String modelName;
    private Brand brands;
    private List<Orders> orderss;
}
