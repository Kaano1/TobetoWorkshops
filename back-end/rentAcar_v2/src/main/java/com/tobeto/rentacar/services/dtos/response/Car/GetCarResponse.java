package com.tobeto.rentacar.services.dtos.response.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
    private int id;
    private int kilometer;
    private int year;
    private double dailyPrice;
    private String plate;
    private String colorName;
    private String  modelName;
    private String brandName;
}
