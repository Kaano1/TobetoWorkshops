package com.tobeto.rentacar.services.dtos.request.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;
    private int id;
    private int brandId;
}
