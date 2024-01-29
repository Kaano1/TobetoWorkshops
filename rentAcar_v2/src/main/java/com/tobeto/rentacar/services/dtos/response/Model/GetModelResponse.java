package com.tobeto.rentacar.services.dtos.response.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelResponse {
    private String name;
    private String brandName;

}
