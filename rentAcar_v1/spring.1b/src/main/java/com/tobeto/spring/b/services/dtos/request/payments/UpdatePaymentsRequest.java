package com.tobeto.spring.b.services.dtos.request.payments;

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
public class UpdatePaymentsRequest {

    @NotBlank(message = "You must specify which payments update")
    @NotNull(message = "You do not have to enter null")
    @Min(0)
    private int id;

    @NotBlank(message = "Please enter a payment method...")
    @Size(min = 3)
    private String paymentMethod;

    @NotBlank(message = "you must specify limit")
    @Min(10)
    private int limit;

    @NotBlank(message = "Sorry, you didn't enter card_number!\nPlease enter a card number...")
    @Size(min = 16)
    private String cardNumber;

    private int agreementId;
}
