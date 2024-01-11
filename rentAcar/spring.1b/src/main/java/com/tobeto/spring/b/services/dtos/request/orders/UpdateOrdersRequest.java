package com.tobeto.spring.b.services.dtos.request.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrdersRequest {
    @NotBlank(message = "You must specify which order update")
    @NotNull(message = "You do not have to enter null")
    @Min(0)
    private int id;

    @NotNull
    @NotBlank(message = "when is the start time")
    @Past
    private LocalDate startDate;

    @NotBlank(message = "when is the end time")
    @NotNull
    @Past
    private LocalDate endDate;

    @Min(0)
    private int amount;

    private int customerId;

    private int carsId;
}
