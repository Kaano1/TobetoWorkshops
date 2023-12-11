package com.tobeto.spring.b.services.dtos.response.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private String payMethod;
    private int amount;
    private int cardNumber;
}
