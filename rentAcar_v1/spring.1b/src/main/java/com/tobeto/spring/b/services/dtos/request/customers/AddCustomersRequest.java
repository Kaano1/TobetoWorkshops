package com.tobeto.spring.b.services.dtos.request.customers;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomersRequest {
    @NotBlank(message = "Hey!! you didn't enter customer's name in input.")
    @NotNull
    @Size(min = 3)
    private String name;

    @NotBlank(message = "Hop! you didn't enter customer's surname in input.")
    @NotNull
    @Size(min = 3)
    private String surname;

    @NotBlank(message = "What's customer phone number?")
    @NotNull
    @Size(min = 9)
    private String phone;

    @NotBlank(message = "Please enter mail address")
    @NotNull
    @Email
    private String gmail;

    @Value("-1")
    private int addressId;
}
