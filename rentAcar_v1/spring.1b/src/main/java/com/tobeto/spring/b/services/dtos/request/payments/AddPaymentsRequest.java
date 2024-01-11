package com.tobeto.spring.b.services.dtos.request.payments;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentsRequest {
    @NotBlank(message = "Please enter a payment method...")
    @Size(min = 3)
    @NotNull
    private String paymentMethod;

    @NotBlank(message = "you must specify limit")
    @Min(10)
    @NotNull
    private int limit;

    @NotBlank(message = "Sorry, you didn't enter card_number!\nPlease enter a card number...")
    @Size(min = 16)
    @NotNull
    private String cardNumber;

    @Value("-1")
    private int agreementId;
}
