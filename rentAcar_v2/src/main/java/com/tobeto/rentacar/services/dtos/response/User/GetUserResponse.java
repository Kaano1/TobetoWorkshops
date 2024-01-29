package com.tobeto.rentacar.services.dtos.response.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
    private String firstName;
    private String lastName;
    private String gsm;
    private String email;
}
