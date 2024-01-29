package com.tobeto.spring.b.services.dtos.request.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrdersRequest {

    @NotBlank(message = "when is the start time")
    @NotNull
    @Past
    private LocalDate startDate;

    @NotBlank(message = "when is the end time")
    @NotNull
    @Past
    private LocalDate endDate;

    @Min(0)
    private int amount;

    @Value("-1")
    private int customerId;

    @Value("-1")
    private int carsId;
}
