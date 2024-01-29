package com.tobeto.rentacar.services.dtos.request.User;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String firstName;

    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String lastName;

   // @Size(min = 10, max = 10, message = "10 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "invalid format: 10 characters can be entered")
    private String gsm;

    @Email(message = "The string has to be a well-formed email address")
    @NotBlank(message = "This field cannot be left blank")
    private String email;
}
