package com.tobeto.rentacar.services.dtos.request.Car;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequest {
    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int kilometer;

    @Min(value = 2005, message = "Year cannot be less than 2005")
    @Max(value = 2024, message = "The year cannot be greater than 2024")
    private int year;

    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private double dailyPrice;

    @Pattern(regexp = "^[0-9]{2} [A-Z]{1,3} [0-9]{2,5}$", message = "invalid format")
    @Size(min = 7)
    @NotBlank
    private String plate;

    private short minFindeksRate;

    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int colorId;
    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int modelId;

}
