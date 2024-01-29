package com.tobeto.spring.b.services.dtos.request.cars;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarsRequest {

    @NotBlank(message = "what is the model name?")
    @NotNull
    @Size(min = 3)
    private String modelName;

    @NotBlank(message = "you must enter model year!!!")
    @NotNull
    @Size(min = 3)
    private String modelYear;

    @Value("-1")
    @Min(0)
    private int brandId;
}
