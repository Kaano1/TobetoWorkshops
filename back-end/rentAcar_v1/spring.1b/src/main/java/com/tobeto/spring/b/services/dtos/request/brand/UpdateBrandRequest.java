package com.tobeto.spring.b.services.dtos.request.brand;

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
public class UpdateBrandRequest {
    @Min(0)
    @NotBlank(message = "Please tell me, which brand do you want to change")
    @NotNull(message = "Please tell me, which brand do you want to change?")
    private int id;

    @NotBlank(message = "Please write a brand of name!")
    @NotNull
    @Size(min = 3, max = 10)
    private String name;
}
