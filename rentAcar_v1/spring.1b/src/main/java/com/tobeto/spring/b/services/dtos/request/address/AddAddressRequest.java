package com.tobeto.spring.b.services.dtos.request.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    @NotBlank(message = "you must specify which town")
    @NotNull
    @Size(min = 3)
    private String town;

    @NotBlank(message = "you must specify which city")
    @NotNull
    @Size(min = 3)
    private String city;

    @NotBlank(message = "you must specify which country")
    @NotNull
    @Size(min = 3)
    private String country;

    @NotBlank(message = "you must specify address detail")
    @NotNull
    @Size(min = 12)
    private String detail;

    @Value("-1")
    private List<Integer> customerId;
}
