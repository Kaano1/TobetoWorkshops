package com.tobeto.spring.b.services.dtos.request.customers;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomersRequest {

    @NotBlank(message = "You must specify which customer update")
    @NotNull(message = "You do not have to enter null")
    @Min(0)
    private int id;

    @NotBlank(message = "Hey!! you didn't enter customer's name in input.")
    @Size(min = 3)
    @NotNull
    private String name;

    @NotBlank(message = "Hop! you didn't enter customer's surname in input.")
    @Size(min = 3)
    @NotNull
    private String surname;

    @NotBlank(message = "What's customer phone number?")
    @Size(min = 9)
    @NotNull
    private String phone;

    @NotBlank(message = "Please enter mail address")
    @NotNull
    @Email
    private String gmail;

    private int addressId;
}
