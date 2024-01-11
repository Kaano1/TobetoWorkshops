package com.tobeto.spring.b.services.dtos.request.cars;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarsRequest {
    @NotBlank(message = "Please tell me, which car do you want to change")
    @NotNull(message = "Please tell me, which car do you want to change")
    @Min(0)
    private int id;

    @NotBlank(message = "what is the model name?")
    @NotNull
    @Size(min = 3)
    private String modelName;

    @NotBlank(message = "you must enter model year!!!")
    @Size(min = 3)
    @NotNull
    private String modelYear;

    @NotBlank(message = "you must enter model year!!!")
    @Min(0)
    @NotNull
    private int brandId;

}
